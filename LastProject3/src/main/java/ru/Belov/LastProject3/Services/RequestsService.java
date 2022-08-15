package ru.Belov.LastProject3.Services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Models.RequestsModel;
import ru.Belov.LastProject3.Repositories.BannerRepositories;
import ru.Belov.LastProject3.Repositories.RequestsRepositories;
import ru.Belov.LastProject3.until.Exceptions.RequestWithBannerNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class RequestsService {
    private  final
    RequestsRepositories requestsRepositories;
    private final BannerRepositories bannerRepositories;
    private final EntityManager entityManager;
@Autowired
    public RequestsService(RequestsRepositories requestsRepositories, BannerRepositories bannerRepositories, EntityManager entityManager) {
        this.requestsRepositories = requestsRepositories;
        this.bannerRepositories = bannerRepositories;
    this.entityManager = entityManager;
}

    @Transactional
    public RequestsModel create(HttpServletRequest httpServletRequest,RequestsModel requestsModel)  {


        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpServletRequest.getRemoteAddr();
        }
        requestsModel.setIpAddress(ipAddress);

        Date date = new Date();
        requestsModel.setDate(date);


        requestsModel.setUserAgent(httpServletRequest.getHeader("User-Agent"));
        requestsRepositories.save(requestsModel);
        return requestsModel;

    }
    @Transactional
    public RequestsModel getRequests(HttpServletRequest httpServletRequest) {
    Session session=entityManager.unwrap(Session.class);
        String ip = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
            ip = httpServletRequest.getRemoteAddr();
        }
        List<Integer> requestsModelList=session.createQuery("SELECT p.bannerModels.id  from RequestsModel p  where p.ipAddress=:ip and p.bannerModels.deleted=false ",Integer.class).setParameter("ip",ip).getResultList();

        List<Integer> bannerModelList=session.createQuery("select p.id from BannerModel p where p.deleted=false ",Integer.class).getResultList();

        Set<Integer> requestsModelSet=new HashSet<>(requestsModelList);
        Set<Integer>  bannerModelSet=new LinkedHashSet<>( bannerModelList);
        bannerModelSet.removeAll(requestsModelSet);

        List<Integer> listBannerToSet=new ArrayList<>();
        listBannerToSet.addAll(bannerModelSet);
        if(listBannerToSet.size()==0){
            throw new RequestWithBannerNotFoundException("NoBanner");
        }


        Random random=new Random();
        RequestsModel requestsModel=new RequestsModel();

        int id =random.nextInt(listBannerToSet.size());
        id=listBannerToSet.get(id);
        requestsModel.setBannerModels(bannerRepositories.findById(id ).get());

        return create(httpServletRequest,requestsModel);


    }
}

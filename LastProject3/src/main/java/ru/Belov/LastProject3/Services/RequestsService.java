package ru.Belov.LastProject3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Belov.LastProject3.Models.RequestsModel;
import ru.Belov.LastProject3.Repositories.BannerRepositories;
import ru.Belov.LastProject3.Repositories.RequestsRepositories;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

@Service
@Transactional(readOnly = true)
public class RequestsService {
    private  final
    RequestsRepositories requestsRepositories;
    private final BannerRepositories bannerRepositories;
@Autowired
    public RequestsService(RequestsRepositories requestsRepositories, BannerRepositories bannerRepositories) {
        this.requestsRepositories = requestsRepositories;
        this.bannerRepositories = bannerRepositories;
    }

    @Transactional
    public void create(HttpServletRequest httpServletRequest)  {
        RequestsModel requestsModel=new RequestsModel();

        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpServletRequest.getRemoteAddr();
        }
        requestsModel.setIpAddress(ipAddress);

        Date date = new Date();
        requestsModel.setDate(date);

        Random random=new Random();
        requestsModel.setBannerModels(bannerRepositories.getReferenceById(random.nextInt(5)));//логика добавления банира в запрос и чтобы не был одинаковый

        requestsModel.setUserAgent(httpServletRequest.getHeader("User-Agent"));
        requestsRepositories.save(requestsModel);

    }
}

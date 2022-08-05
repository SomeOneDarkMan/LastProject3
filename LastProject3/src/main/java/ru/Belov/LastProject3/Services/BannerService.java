package ru.Belov.LastProject3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Repositories.BannerRepositories;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BannerService {
    private final
    BannerRepositories bannerRepositories;
    @Autowired
    public BannerService(BannerRepositories bannerRepositories) {
        this.bannerRepositories = bannerRepositories;
    }
    @Transactional
    public void create(BannerModel bannerModel){
        bannerRepositories.save(bannerModel);
    }

    public BannerModel getBannerId(int id) {
        Optional<BannerModel> modelBannerOptional=bannerRepositories.findById(id);

    return modelBannerOptional.orElse(null);
    }
}

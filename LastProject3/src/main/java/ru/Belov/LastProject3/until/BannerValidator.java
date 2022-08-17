package ru.Belov.LastProject3.until;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Services.BannerService;

import java.util.Optional;

@Component
public class BannerValidator implements Validator {
    private final BannerService bannerService;
    @Autowired
    public BannerValidator(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return BannerModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BannerModel bannerModel=(BannerModel) target;
        Optional<BannerModel> bannerModelOptional=bannerService.checkBannerForValid(bannerModel.getName());
        if(bannerModelOptional.isPresent()){
            errors.rejectValue("name","","there must be  Banner with this unique Name");
        }

    }
}

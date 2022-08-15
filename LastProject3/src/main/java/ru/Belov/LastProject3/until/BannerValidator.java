package ru.Belov.LastProject3.until;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Belov.LastProject3.DTO.DTOBannerModel;
import ru.Belov.LastProject3.Models.BannerModel;

@Component
public class BannerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BannerModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

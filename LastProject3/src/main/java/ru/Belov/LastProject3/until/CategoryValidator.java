package ru.Belov.LastProject3.until;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Belov.LastProject3.DTO.DTOCategoryModel;
import ru.Belov.LastProject3.Models.CategoryModel;
@Component
public class CategoryValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

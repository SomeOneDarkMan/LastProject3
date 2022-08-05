package ru.Belov.LastProject3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Models.CategoryModel;
import ru.Belov.LastProject3.Repositories.CategoryRepositories;

import java.util.Collections;

@Service
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepositories categoryRepositories;
    @Autowired
    public CategoryService(CategoryRepositories categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }

    @Transactional
    public void create(CategoryModel categoryModel){

        categoryRepositories.save(categoryModel);
    }
}

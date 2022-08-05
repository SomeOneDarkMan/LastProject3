package ru.Belov.LastProject3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Models.CategoryModel;
import ru.Belov.LastProject3.Services.CategoryService;

@RestController
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<HttpStatus> createBanner(@RequestBody CategoryModel categoryModel){
        categoryService.create(categoryModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

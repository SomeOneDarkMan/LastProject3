package ru.Belov.LastProject3.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Belov.LastProject3.Models.CategoryModel;
import ru.Belov.LastProject3.Services.CategoryService;
import ru.Belov.LastProject3.until.CategoryValidator;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final CategoryValidator categoryValidator;
    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper, CategoryValidator categoryValidator) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.categoryValidator = categoryValidator;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<HttpStatus> createBanner(@RequestBody CategoryModel categoryModel){
        categoryService.create(categoryModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

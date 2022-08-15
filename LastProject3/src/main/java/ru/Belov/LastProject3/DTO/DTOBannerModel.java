package ru.Belov.LastProject3.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.Belov.LastProject3.Models.CategoryModel;
import ru.Belov.LastProject3.Models.RequestsModel;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class DTOBannerModel {

    private int id;
    String name;
    String content;
    boolean deleted;
    float price;
    @JsonIgnore
    CategoryModel categoryModel;
    @JsonIgnore
    List<RequestsModel> requestsModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTOBannerModel that = (DTOBannerModel) o;
        return id == that.id && Float.compare(that.price, price) == 0 && name.equals(that.name) && content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public List<RequestsModel> getRequestsModel() {
        return requestsModel;
    }

    public void setRequestsModel(List<RequestsModel> requestsModel) {
        this.requestsModel = requestsModel;
    }
}

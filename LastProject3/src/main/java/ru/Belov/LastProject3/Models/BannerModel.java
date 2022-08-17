package ru.Belov.LastProject3.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Banner")
public class BannerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    private int id;

    @Column(name = "NAME")
    String name;

    @Column(name = "CONTENT")
    String content;
    @Column(name = "DELETED")
    boolean deleted;

    @Column(name = "PRICE")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    float price;

    @ManyToOne(fetch =FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    CategoryModel categoryModel;
    @OneToMany (mappedBy = "bannerModels",fetch =FetchType.LAZY)//
    //@JsonManagedReference
    @JsonIgnore
    List<RequestsModel> requestsModel;

    public BannerModel() {
    }


    public int getBannerId() {
        return id;
    }

    public void setBannerId(int bannerId) {
        this.id = bannerId;
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

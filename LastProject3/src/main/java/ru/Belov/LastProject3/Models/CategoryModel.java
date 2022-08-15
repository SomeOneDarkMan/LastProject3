package ru.Belov.LastProject3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "NAME")
    String name;
     @Column(name = "REQ_NAME")
    String reqName;
    @Column(name = "DELETED")
    boolean deleted;
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonManagedReference
    @OneToMany(mappedBy = "categoryModel",fetch =FetchType.LAZY)
    List<BannerModel>bannerModels;
    public CategoryModel(){}

    public List<BannerModel> getBannerModels() {
        return bannerModels;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public void setBannerModels(List<BannerModel> bannerModels) {
        this.bannerModels = bannerModels;
    }

    public int getCategoryId() {
        return id;
    }

    public void setCategoryId(int categoryId) {
        this.id = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

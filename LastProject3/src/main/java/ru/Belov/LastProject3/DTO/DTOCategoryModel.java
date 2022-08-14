package ru.Belov.LastProject3.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.Belov.LastProject3.Models.BannerModel;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class DTOCategoryModel {
    int id;
    String name;
    String reqName;
    boolean deleted;
    List<BannerModel> bannerModels;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTOCategoryModel that = (DTOCategoryModel) o;
        return id == that.id && name.equals(that.name) && reqName.equals(that.reqName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, reqName);
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

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<BannerModel> getBannerModels() {
        return bannerModels;
    }

    public void setBannerModels(List<BannerModel> bannerModels) {
        this.bannerModels = bannerModels;
    }
}

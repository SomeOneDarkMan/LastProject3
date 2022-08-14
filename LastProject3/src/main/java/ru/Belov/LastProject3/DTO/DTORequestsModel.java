package ru.Belov.LastProject3.DTO;

import org.springframework.format.annotation.DateTimeFormat;
import ru.Belov.LastProject3.Models.BannerModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

public class DTORequestsModel {

    int id;
    String userAgent;
    String ipAddress;
    Date date;
    BannerModel bannerModels;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTORequestsModel that = (DTORequestsModel) o;
        return id == that.id && userAgent.equals(that.userAgent) && ipAddress.equals(that.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userAgent, ipAddress);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BannerModel getBannerModels() {
        return bannerModels;
    }

    public void setBannerModels(BannerModel bannerModels) {
        this.bannerModels = bannerModels;
    }
}

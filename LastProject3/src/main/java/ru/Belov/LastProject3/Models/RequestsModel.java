package ru.Belov.LastProject3.Models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Requests")
public class RequestsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    int id;
    @Column(name = "USER_AGENT")
    String userAgent;
    @Column(name = "IP_ADDRESS")
    String ipAddress;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date date;
    @ManyToOne()
    @JoinColumn(name = "BANNER_ID", referencedColumnName = "ID")
    BannerModel bannerModels;
    public RequestsModel(){}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRequestsId() {
        return id;
    }

    public void setRequestsId(int requestsId) {
        this.id = requestsId;
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

    public BannerModel getBannerModels() {
        return bannerModels;
    }

    public void setBannerModels(BannerModel bannerModels) {
        this.bannerModels = bannerModels;
    }
}

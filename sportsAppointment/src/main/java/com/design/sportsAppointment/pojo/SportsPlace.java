package com.design.sportsAppointment.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (SportsPlace)实体类
 *
 * @author makejava
 * @since 2023-01-01 09:30:59
 */
public class SportsPlace implements Serializable {
    private static final long serialVersionUID = 941506761701499989L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 体育馆id 记录是哪一个体育馆的场地
     */
    private Integer sportsId;
     /**
     * 场地名称(比如羽毛球场 篮球场 )
     */
    private String placeName;
     /**
     * 照片
     */
    private String images;
    private String imagesUrl;
     /**
     * 录入时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 录入人
     */
    private String createdBy;
     /**
     * 营业时间(开始时间)
     */
    private String startTime;
     /**
     * 营业时间(结束时间)
     */
    private String endTime;
    private String   sportsName;
    private Double prices;

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public String getSportsName() {
        return sportsName;
    }

    public void setSportsName(String sportsName) {
        this.sportsName = sportsName;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSportsId() {
        return sportsId;
    }

    public void setSportsId(Integer sportsId) {
        this.sportsId = sportsId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}


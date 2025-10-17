package com.design.sportsAppointment.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Rent)实体类
 *
 * @author makejava
 * @since 2023-01-01 19:04:50
 */
public class Rent implements Serializable {
    private static final long serialVersionUID = -62125269916595726L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 创建时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 租借人
     */
    private String createdBy;
     /**
     * 数量
     */
    private Integer num;
     /**
     * 费用
     */
    private Double fee;
     /**
     * 是否结帐 1 为 结账 0 为未结账
     */
    private Integer status;
     /**
     * 取消时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date deletedAt;
     /**
     * 器材名称记录是哪一个器材
     */
    private String name;

    private Boolean disabled;
    private String orderStatus;
    private Integer goBack;
    private Integer year;
    private String month;
    private String yearMonth;
    private Double sum;
    private Boolean backDisabled;
    public Boolean getBackDisabled() {
        return backDisabled;
    }

    public void setBackDisabled(Boolean backDisabled) {
        this.backDisabled = backDisabled;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getGoBack() {
        return goBack;
    }

    public void setGoBack(Integer goBack) {
        this.goBack = goBack;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


package com.example.JiangHu;


import java.io.Serializable;

/**
 * 新闻实体类
 * Created by Administrator on 2015/1/18.
 */
public class TaskItem implements Serializable{

    private String university;
    private String location;
    private String title;   //标题
    private String content;
    private String status;//订单状态

    private String contactor;

    private String phoneNumber;

    private String beginDate;

    private String endDate;

    private String desc;

    private String payment;

    private String workType;

    private String acccessbility;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getStatus() {
        return  status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                ", title='" + title + '\'' +
                ", price='" + payment + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", between[" + beginDate + ","+ endDate+"]" +
                '}';
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getAcccessbility() {
        return acccessbility;
    }

    public void setAcccessbility(String acccessbility) {
        this.acccessbility = acccessbility;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getBeginDate()
    {
        return this.beginDate;
    }

    public String getEndDate()
    {
        return this.endDate;
    }

    public String getPayment()
    {
        return this.payment;
    }
}

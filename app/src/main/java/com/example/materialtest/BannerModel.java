package com.example.materialtest;

public class BannerModel {

    private String imageUrl;
    private Integer imageId;
    private String mTips;

    public String getTips() {
        return mTips;
    }

    public void setTips(String tips) {
        mTips = tips;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImageId(Integer id)
    {
        this.imageId = id;
    }

    public Integer getImageId()
    {
        return imageId;
    }

}

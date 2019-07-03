package com.geeknum1.scrollindicator;


/**
 * Created by mustang on 2019/07/03.
 */
public class BottomPopBean {

    private int image;

    private String subTitle;

    private String title;

    public BottomPopBean(int image, String subTitle, String title) {
        this.image = image;
        this.subTitle = subTitle;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

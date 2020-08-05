package com.example.mask_detector.model;

import java.io.Serializable;

public class Articles implements Serializable {
    String name;
    Integer image;
    String title;
    String desc;

    public Articles(String name, Integer image, String title, String desc) {
        this.name = name;
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public Articles() {
    }

    public String getName() {
        return name;
    }

    public Integer getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}

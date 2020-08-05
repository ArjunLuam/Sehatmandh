package com.example.mask_detector.model;

import java.io.Serializable;

public class ArticleContent implements Serializable {
    String text;
    String name;
    String expectedReadingtime;

    public String getName() {
        return name;
    }

    public ArticleContent(String text, String expectedReadingtime, String name) {
        this.text = text;
        this.expectedReadingtime = expectedReadingtime;
        this.name=name;
    }

    public String getText() {
        return text;
    }

    public String getExpectedReadingtime() {
        return expectedReadingtime;
    }
}

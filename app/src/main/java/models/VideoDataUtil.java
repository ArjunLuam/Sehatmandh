package com.example.mask_detector.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class VideoDataUtil implements Serializable {
    private String url;
    private String name;
    private ArrayList<String> tags;
    private HashMap<String, String> similarVideos;
    private ArrayList<ArticleContent> data;

    public VideoDataUtil(String url, String name, ArrayList<String> tags, HashMap<String, String> similarVideos, ArrayList<ArticleContent> data) {
        this.url = url;
        this.name = name;
        this.tags = tags;
        this.similarVideos = similarVideos;
        this.data=data;
    }

    public ArrayList<ArticleContent> getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public HashMap<String, String> getSimilarVideos() {
        return similarVideos;
    }

    public void setSimilarVideos(HashMap<String, String> similarVideos) {
        this.similarVideos = similarVideos;
    }
}
//    How to boost immune System Naturally?
//        https://www.youtube.com/watch?v=y034QnYq0F8
//
//        Tags: Immunity, Healthy food, health, natural remedy
//
//
//
//        How To Boost Immune System Against Coronavirus Infection
//        https://www.youtube.com/watch?v=u7YefBaeub4
//
//        Tags: Immunity, covid19, corona virus
//
//
//
//        Strengthen Your Immune System With 4 Simple Strategies
//
//        https://health.clevelandclinic.org/strengthen-your-immune-system-with-simple-strategies/
//
//        Tags: Immunity, Healthy food, lifestyle
//Corona
//https://www.youtube.com/watch?v=sHP0UIdZyI4
//https://www.youtube.com/watch?v=sWjYs7aILZ8
//Diabetes
//https://www.youtube.com/watch?v=X9ivR4y03DE
//https://www.youtube.com/watch?v=JAjZv41iUJU
//https://www.youtube.com/watch?v=U9GAWJYOg9Q
//https://www.youtube.com/watch?v=qSpAF-JUKEA
//CardiacArrest
//https://www.youtube.com/watch?v=7lMiXJH_bw4
//https://www.youtube.com/watch?v=69CQsdPC2i8
//https://www.youtube.com/watch?v=9emAmwJ3vFw
//https://www.youtube.com/watch?v=a4bkT4m22Lk
//https://www.youtube.com/watch?v=LPsW8WOcpEQ
//Malaria
//https://www.youtube.com/watch?v=1v55yg0RfoY
//https://www.youtube.com/watch?v=MxiWp8vkRFI
//https://www.youtube.com/watch?v=INmIcOPKo_M
//https://www.youtube.com/watch?v=6vDwG_rz_PU
//TB
//https://www.youtube.com/watch?v=N0Gv96uDctM
//https://youtu.be/Ory6peTgTEo
//https://www.youtube.com/watch?v=hAXnQgU4bsg
//https://www.youtube.com/watch?v=wA_fObLY6GE
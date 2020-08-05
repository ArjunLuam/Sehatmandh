package com.example.mask_detector.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mask_detector.R;
import com.example.mask_detector.adapter.VideoAdapter;
import com.example.mask_detector.model.ArticleContent;
import com.example.mask_detector.model.VideoDataUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class MediaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_media, container, false);
        ArrayList<VideoDataUtil> videoDataUtils = intitData();
        RecyclerView mRecyclerView = v.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        VideoAdapter mAdapter = new VideoAdapter(videoDataUtils, getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    private ArrayList<VideoDataUtil> intitData() {
        ArrayList<VideoDataUtil> videos = new ArrayList<>();

        String url1 = "https://www.youtube.com/watch?v=sHP0UIdZyI4";
        String name1 = "What Is Coronavirus (COVID-19)?";
        ArrayList<String> label1 = new ArrayList<>();
        HashMap<String, String> videoDataUtils1 = new HashMap<>();
        ArrayList<ArticleContent> articleList1=new ArrayList<>();
        articleList1.add(new ArticleContent("https://en.wikipedia.org/wiki/Coronavirus","20 mins","Covid19"));
        articleList1.add(new ArticleContent("https://www.webmd.com/lung/coronavirus","15 mins","Symptons of Covid19"));
        articleList1.add(new ArticleContent("https://www.worldometers.info/coronavirus/","10 mins","Covid19 Current Situation"));
        videoDataUtils1.put("CORONAVIRUS PANDEMIC EXPLAINED - CORONA OUTBREAK 2020", "https://www.youtube.com/watch?v=sWjYs7aILZ8");
        videoDataUtils1.put(" How To Boost Immune System Against Coronavirus Infection","https://www.youtube.com/watch?v=u7YefBaeub4");
        //Todo set recommended data

        VideoDataUtil video1 = new VideoDataUtil(url1, name1, label1, videoDataUtils1,articleList1);

        String url2 = "https://www.youtube.com/watch?v=JAjZv41iUJU";
        String name2 = "Understanding Type 2 Diabetes";
        ArrayList<String> label2 = new ArrayList<>();
        HashMap<String, String> videoDataUtils2 = new HashMap<>();
        ArrayList<ArticleContent> articleList2=new ArrayList<>();
        articleList2.add(new ArticleContent("https://en.wikipedia.org/wiki/Diabetes","25 mins","Diabetes"));
        articleList2.add(new ArticleContent("https://en.wikipedia.org/wiki/Type_2_diabetes","40mins","Type2 Diabetes"));
        articleList2.add(new ArticleContent("https://en.wikipedia.org/wiki/Type_1_diabetes","35mins","Type1 Diabetes"));
        videoDataUtils2.put("Treatment and Management of Type 2 Diabetes","https://www.youtube.com/watch?v=qSpAF-JUKEA");
        videoDataUtils2.put("Diabetes Prevention","https://www.youtube.com/watch?v=U9GAWJYOg9Q");
        //Todo set recommended video
        VideoDataUtil video2 = new VideoDataUtil(url2, name2, label2, videoDataUtils2,articleList2);

        String url3 = "https://www.youtube.com/watch?v=7lMiXJH_bw4";
        String name3 = "What is a cardiac arrest?";
        ArrayList<String> label3 = new ArrayList<>();
        HashMap<String, String> videoDataUtils3 = new HashMap<>();
        ArrayList<ArticleContent> articleList3=new ArrayList<>();
        articleList3.add(new ArticleContent("https://en.wikipedia.org/wiki/Cardiac_arrest","35 mins","Cardiac Arrest"));
        articleList3.add(new ArticleContent("https://www.heart.org/en/health-topics/heart-attack/about-heart-attacks/heart-attack-or-sudden-cardiac-arrest-how-are-they-different","14 mins","Heart Attack vs Cardiac Arrest"));
        videoDataUtils3.put("What Happens in a Heart Attack vs. Cardiac Arrest?","https://www.youtube.com/watch?v=69CQsdPC2i8");
        videoDataUtils3.put("Symptoms of Sudden Cardiac Arrest | Cedars-Sinai","https://www.youtube.com/watch?v=9emAmwJ3vFw");
        videoDataUtils3.put("How to prevent sudden cardiac death in the young","https://www.youtube.com/watch?v=a4bkT4m22Lk");
        videoDataUtils3.put("Signs of sudden cardiac arrest could show up early","https://www.youtube.com/watch?v=LPsW8WOcpEQ");
        //Todo set recommended data
        VideoDataUtil video3 = new VideoDataUtil(url3, name3, label3, videoDataUtils3,articleList3);

        String url4 = "https://www.youtube.com/watch?v=1v55yg0RfoY";
        String name4 = "Malaria Lifecycle Part 1: Human Host (2016)";
        ArrayList<String> label4 = new ArrayList<>();
        HashMap<String, String> videoDataUtils4 = new HashMap<>();
        ArrayList<ArticleContent> articleList4=new ArrayList<>();
        articleList4.add(new ArticleContent("https://en.wikipedia.org/wiki/Malaria","25 mins","Malaria"));
        articleList4.add(new ArticleContent("https://www.who.int/news-room/fact-sheets/detail/malaria","15mins","WHO on Malaria"));
        articleList4.add(new ArticleContent("https://www.healthline.com/health/malaria","22mins","Malaria Complete Info"));
        videoDataUtils4.put("Malaria Lifecycle Part 2: Mosquito Host (2016)","https://www.youtube.com/watch?v=MxiWp8vkRFI");
        videoDataUtils4.put("Preventing malaria | Infectious diseases | NCLEX-RN | Khan Academy","https://www.youtube.com/watch?v=INmIcOPKo_M");
        videoDataUtils4.put("Treatment of malaria | Infectious diseases | NCLEX-RN | Khan Academy","https://www.youtube.com/watch?v=6vDwG_rz_PU");

        //Todo set recommended data
        VideoDataUtil video4 = new VideoDataUtil(url4, name4, label4, videoDataUtils4,articleList4);

        String url5 = "https://www.youtube.com/watch?v=oJM0-bDIzKA";
        String name5 = "Tuberculosis : an Osmosis preview";
        ArrayList<String> label5 = new ArrayList<>();
        HashMap<String, String> videoDataUtils5 = new HashMap<>();
        ArrayList<ArticleContent> articleList5=new ArrayList<>();
        articleList5.add(new ArticleContent("https://en.wikipedia.org/wiki/Tuberculosis","20 mins","Tuberculosis"));
        articleList5.add(new ArticleContent("https://www.who.int/news-room/fact-sheets/detail/tuberculosis","18mins","WHO on Tuberculosis"));
        videoDataUtils5.put("What is Tuberculosis", "https://www.youtube.com/watch?v=ZVBU6P9VdH4");
        videoDataUtils5.put("Preventing TB transmission | Infectious diseases | NCLEX-RN | Khan Academy","https://www.youtube.com/watch?v=hAXnQgU4bsg");
        videoDataUtils5.put("5 Things to Know About TB","https://www.youtube.com/watch?v=wA_fObLY6GE");

        //Todo set recommended data
        VideoDataUtil video5 = new VideoDataUtil(url5, name5, label5, videoDataUtils5,articleList5);

        videos.add(video1);
        videos.add(video2);
        videos.add(video3);
        videos.add(video4);
        videos.add(video5);
        return videos;
    }
}
package com.example.mask_detector.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mask_detector.R;
import com.example.mask_detector.adapter.ArticleAdapter;
import com.example.mask_detector.adapter.ArticleAdapter2;
import com.example.mask_detector.model.ArticleContent;
import com.example.mask_detector.model.VideoDataUtil;

import java.util.ArrayList;


public class ArticlesFragment extends Fragment {
    RecyclerView rvContent;
    LinearLayoutManager manager;
    ArticleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_articles, container, false);
        VideoDataUtil video = (VideoDataUtil) getActivity().getIntent().getSerializableExtra("video");
        ArrayList<ArticleContent> contents = video.getData();
        rvContent = v.findViewById(R.id.article_recommended);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContent.setAdapter(new ArticleAdapter2(contents, getContext()));
        return v;
    }
}
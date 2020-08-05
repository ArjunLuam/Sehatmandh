package com.example.mask_detector.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mask_detector.R;
import com.example.mask_detector.adapter.ArticleAdapter;
import com.example.mask_detector.model.Articles;

import java.util.ArrayList;

public class ReadArticleActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Articles> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_article);
        initData();
        rv = findViewById(R.id.rv);
        rv.setAdapter(new ArticleAdapter(this, articles));
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.hasFixedSize();
    }

    private void initData() {
        articles = new ArrayList<>();

        Articles articles1 = new Articles("Narendra Modi", R.drawable.ic_launcher_foreground, "Title1", "Description1");
        Articles articles2 = new Articles("Narendra Modi", R.drawable.ic_launcher_foreground, "Title1", "Description1");
        Articles articles3 = new Articles("Narendra Modi", R.drawable.ic_launcher_foreground, "Title1", "Description1");
        Articles articles4 = new Articles("Narendra Modi", R.drawable.ic_launcher_foreground, "Title1", "Description1");
        Articles articles5 = new Articles("Narendra Modi", R.drawable.ic_launcher_foreground, "Title1", "Description1");
        Articles articles6 = new Articles("Narendra Modi", R.drawable.ic_launcher_foreground, "Title1", "Description1");
        Articles articles7 = new Articles("Narendra Modi", R.drawable.ic_launcher_foreground, "Title1", "Description1");

        articles.add(articles1);
        articles.add(articles2);
        articles.add(articles3);
        articles.add(articles4);
        articles.add(articles5);
        articles.add(articles6);
        articles.add(articles7);
    }
}
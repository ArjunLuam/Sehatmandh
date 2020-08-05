package com.example.mask_detector.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mask_detector.R;
import com.example.mask_detector.activities.ReadArticle;
import com.example.mask_detector.model.Articles;

import java.io.Serializable;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    ArrayList<Articles> articles;
    Context context;

    public ArticleAdapter(Context context, ArrayList<Articles> articles) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.article_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Articles article = articles.get(position);
        holder.iv.setImageResource(article.getImage());
        holder.name.setText(article.getName());
        holder.title.setText(article.getTitle());
        holder.desc.setText(article.getDesc());
        holder.ll.setOnClickListener(read -> {
            Intent i = new Intent(context, ReadArticle.class);
            i.putExtra("article", (Serializable) article);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView iv;
        TextView name, title, desc;
        LinearLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.pImage);
            name = itemView.findViewById(R.id.pName);
            title = itemView.findViewById(R.id.postTitle);
            desc = itemView.findViewById(R.id.postDesc);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}

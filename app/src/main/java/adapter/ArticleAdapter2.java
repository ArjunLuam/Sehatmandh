package com.example.mask_detector.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mask_detector.R;
import com.example.mask_detector.activities.ReadContentActivity;
import com.example.mask_detector.model.ArticleContent;

import java.util.ArrayList;

public class ArticleAdapter2 extends RecyclerView.Adapter<ArticleAdapter2.ArticleViewHolder> {
    private ArrayList<ArticleContent> contentlist;
    private Context context;

    public ArticleAdapter2(ArrayList<ArticleContent> contentlist, Context context) {
        this.contentlist = contentlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item, parent, false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        final ArticleContent currentItem = contentlist.get(position);
        holder.title.setText(currentItem.getName());
        holder.expectedreadtime.setText(currentItem.getExpectedReadingtime());
        holder.l_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ReadContentActivity.class);
                i.putExtra("videoUrl", currentItem.getText());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentlist.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumb;
        public TextView title;
        public TextView expectedreadtime;
        private LinearLayout l_layout;


        public ArticleViewHolder(View itemView) {
            super(itemView);
            thumb = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title_view);
            expectedreadtime = itemView.findViewById(R.id.expected_timeview);
            l_layout = itemView.findViewById(R.id.linearlayout_item);
        }
    }
}

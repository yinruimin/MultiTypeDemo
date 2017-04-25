package com.gunther.multitypedemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.drakeet.multitype.ItemViewProvider;

/**
 * 创建者: YIN
 * 创建时间: 2017/4/24 17:01
 * 电子邮箱: yin_ruimin@foxmail.com
 * 描述:
 */

public class PostViewProvider extends ItemViewProvider<Post,PostViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_post, null);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Post post) {
            holder.setData(post);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView cover;
        private final TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.title);
        }
        void setData(@Nullable final Post post){
            cover.setImageResource(post.coverResId);
            title.setText(post.title);
        }
    }
}

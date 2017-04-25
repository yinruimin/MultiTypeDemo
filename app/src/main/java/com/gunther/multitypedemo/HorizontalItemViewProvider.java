package com.gunther.multitypedemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.drakeet.multitype.ItemViewProvider;

/**
 * 创建者: YIN
 * 创建时间: 2017/4/24 17:02
 * 电子邮箱: yin_ruimin@foxmail.com
 * 描述:
 */

public class HorizontalItemViewProvider extends ItemViewProvider<PostList, HorizontalItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_horizontal_list, null);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PostList postList) {
        holder.setPost(postList.posts);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;
        private final LinearLayoutManager linearLayoutManager;
        private final PostAdapter adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = ((RecyclerView) itemView.findViewById(R.id.post_list));
            linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter = new PostAdapter();
            recyclerView.setAdapter(adapter);
        }

        void setPost(List<Post> posts) {
            adapter.setPost(posts);
            adapter.notifyDataSetChanged();
        }
    }
}

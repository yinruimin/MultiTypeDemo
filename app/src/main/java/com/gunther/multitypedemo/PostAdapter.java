package com.gunther.multitypedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

/**
 * 创建者: YIN
 * 创建时间: 2017/4/25 9:37
 * 电子邮箱: yin_ruimin@foxmail.com
 * 描述:
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> list;

    public void setPost(List<Post> list) {
        this.list = list;
    }

    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder holder, int position) {
        Post post = list.get(position);
        holder.cover.setImageResource(post.coverResId);
        holder.title.setText(post.title);
    }

    @Override
    public int getItemCount() {
        return null != list ? list.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cover;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            cover = ((ImageView) itemView.findViewById(R.id.cover));
            title = ((TextView) itemView.findViewById(R.id.title));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

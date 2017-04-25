package com.gunther.multitypedemo;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * 创建者: YIN
 * 创建时间: 2017/4/24 17:01
 * 电子邮箱: yin_ruimin@foxmail.com
 * 描述:
 */

public class PostList {
    final List<Post> posts;

    public PostList(@NonNull List<Post> posts) {
        this.posts = posts;
    }
}

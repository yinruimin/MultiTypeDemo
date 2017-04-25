package com.gunther.multitypedemo;

import android.support.annotation.NonNull;

/**
 * 创建者: YIN
 * 创建时间: 2017/4/24 17:01
 * 电子邮箱: yin_ruimin@foxmail.com
 * 描述:
 */

public class Post {
    public int coverResId;
    public String title;


    public Post(int coverResId, @NonNull final String title) {
        this.coverResId = coverResId;
        this.title = title;
    }
}

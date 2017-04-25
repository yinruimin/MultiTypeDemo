package com.gunther.multitypedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    public static final int SPAN_COUNT = 2;
    List<Object> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
        initData();
    }

    private void initData() {
        JsonData data = new JsonData();
        items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            /* You also could use Category as your CategoryItemContent directly */
            items.add(data.category0);
            items.add(data.postArray[0]);
            items.add(data.postArray[1]);
            items.add(data.postArray[2]);
            items.add(data.postArray[3]);
            items.add(data.postArray[0]);
            items.add(data.postArray[1]);
            items.add(new PostList(data.postList));
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    private void initAdapter() {
        adapter = new MultiTypeAdapter();
//        adapter.applyGlobalMultiTypePool();
        adapter.register(Category.class, new CategoryViewProvider());
        adapter.register(Post.class, new PostViewProvider());
        adapter.register(PostList.class, new HorizontalItemViewProvider());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object o = items.get(position);
                return (o instanceof Category || o instanceof PostList) ? SPAN_COUNT : 1;
            }
        };
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        recyclerView.addItemDecoration(new PostItemDecoration(space,spanSizeLookup));
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private static class JsonData {

        private final String PREFIX = "This is a long title";

        private Post post00 = new Post(R.drawable.img_00, PREFIX + "post00");
        private Post post01 = new Post(R.drawable.img_01, PREFIX + "post01");
        private Post post10 = new Post(R.drawable.img_10, PREFIX + "post10");
        private Post post11 = new Post(R.drawable.img_11, PREFIX + "post11");

        Category category0 = new Category("category");
        Post[] postArray = { post00, post01, post10, post11 };

        List<Post> postList = new ArrayList<>();


        {
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
        }
    }

}

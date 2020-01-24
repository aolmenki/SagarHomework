package com.example.sagarhomework.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.sagarhomework.adapter.PostAdapter;
import com.example.sagarhomework.R;
import com.example.sagarhomework.models.Post;
import com.example.sagarhomework.utilities.NetworkUtils;

public class PostsActivity extends AppCompatActivity implements PostAdapter.PostAdapterOnClickHandler {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        mRecyclerView = findViewById(R.id.rv_posts);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PostAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        NetworkUtils.loadPosts();
    }

    @Override
    public void onClick(Post postClicked) {
        Context context = this;
        Class destinationClass = CommentActivity.class;
        Intent intentStartCommentActivity = new Intent(context, destinationClass);
        intentStartCommentActivity.putExtra(Post.class.getSimpleName(), postClicked);
        startActivity(intentStartCommentActivity);
    }
}

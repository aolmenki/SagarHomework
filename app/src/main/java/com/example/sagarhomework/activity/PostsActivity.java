package com.example.sagarhomework.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sagarhomework.adapter.PostAdapter;
import com.example.sagarhomework.R;
import com.example.sagarhomework.model.Post;
import com.example.sagarhomework.utilities.NetworkUtils;

public class PostsActivity extends AppCompatActivity implements PostAdapter.PostAdapterOnClickHandler {
    private RecyclerView mPosts;
    private PostAdapter mPostsAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        mPosts = findViewById(R.id.rv_posts);
        mProgressBar = findViewById(R.id.post_progress_bar);

        mPosts.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mPosts.setLayoutManager(mLayoutManager);

        mPostsAdapter = new PostAdapter(this);
        mPosts.setAdapter(mPostsAdapter);

        loadPostData();
    }

    private void loadPostData()
    {
        new FetchPostTask().execute();
    }

    @Override
    public void onClick(Post postClicked) {
        Context context = this;
        Class destinationClass = CommentActivity.class;
        Intent intentStartCommentActivity = new Intent(context, destinationClass);
        intentStartCommentActivity.putExtra(Post.class.getSimpleName(), postClicked);
        startActivity(intentStartCommentActivity);
    }

    public class FetchPostTask extends AsyncTask<Void, Void, Post[]>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Post[] doInBackground(Void... voids) {
            return NetworkUtils.loadAllPosts();
        }

        @Override
        protected void onPostExecute(Post[] posts) {
            mPostsAdapter.setPosts(posts);
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
}

package com.example.sagarhomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarhomework.R;
import com.example.sagarhomework.models.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostAdapterViewHolder> {
    private Post[] mPostArray;
    private final PostAdapterOnClickHandler mClickHandler;

    public interface PostAdapterOnClickHandler {
        void onClick(Post postClicked);
    }

    public PostAdapter(PostAdapterOnClickHandler pClickHandler) {
        mClickHandler = pClickHandler;
    }

    class PostAdapterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        final TextView mTitleTextView;
        final TextView mUserTextView;
        final TextView mBodyTextView;

        PostAdapterViewHolder(View view) {
            super(view);
            mTitleTextView = view.findViewById(R.id.tv_post_title);
            mUserTextView = view.findViewById(R.id.tv_post_user);
            mBodyTextView = view.findViewById(R.id.tv_post_body);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int intAdapterPosition = getAdapterPosition();
            Post postClicked = mPostArray[intAdapterPosition];
            mClickHandler.onClick(postClicked);
        }
    }

    @Override
    public PostAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item_post;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new PostAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapterViewHolder postAdapterViewHolder, int position) {
        Post post = mPostArray[position];
        postAdapterViewHolder.mTitleTextView.setText(post.getmStringTitle());
        postAdapterViewHolder.mUserTextView.setText(post.getStringUser());
        postAdapterViewHolder.mBodyTextView.setText(post.getmStringBody());
    }

    @Override
    public int getItemCount() {
        if (null == mPostArray) return 0;
        return mPostArray.length;
    }

    public void setPosts(Post[] pPostArray) {
        mPostArray = pPostArray;
        notifyDataSetChanged();
    }
}

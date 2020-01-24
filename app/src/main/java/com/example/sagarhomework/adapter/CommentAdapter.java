package com.example.sagarhomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sagarhomework.R;
import com.example.sagarhomework.models.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentAdapterViewHolder> {

    private Comment[] mComments;

    public CommentAdapter(){}

    class CommentAdapterViewHolder extends RecyclerView.ViewHolder {
        final TextView mNameTextView;
        final TextView mEmailTextView;
        final TextView mBodyTextView;

        CommentAdapterViewHolder(View view) {
            super(view);
            mNameTextView = view.findViewById(R.id.tv_comment_name);
            mEmailTextView = view.findViewById(R.id.tv_comment_email);
            mBodyTextView = view.findViewById(R.id.tv_comment_body);
        }
    }

    @Override
    public CommentAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item_comment;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new CommentAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentAdapterViewHolder commentAdapterViewHolder, int position) {
        Comment comment = mComments[position];
        commentAdapterViewHolder.mNameTextView.setText(comment.getmStringName());
        commentAdapterViewHolder.mEmailTextView.setText(comment.getmStringEmail());
        commentAdapterViewHolder.mBodyTextView.setText(comment.getmStringBody());
    }

    @Override
    public int getItemCount() {
        if (null == mComments) return 0;
        return mComments.length;
    }

    public void setComments(Comment[] comments) {
        mComments = comments;
        notifyDataSetChanged();
    }
}

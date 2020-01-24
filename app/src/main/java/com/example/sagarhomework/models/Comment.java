package com.example.sagarhomework.models;

public class Comment {

    private int mIntPostId;
    private int mIntId;
    private String mStringName;
    private String mStringEmail;
    private String mStringBody;

    public Comment(int mIntPostId, int mIntId, String mStringName, String mStringEmail, String mStringBody) {
        this.mIntPostId = mIntPostId;
        this.mIntId = mIntId;
        this.mStringName = mStringName;
        this.mStringEmail = mStringEmail;
        this.mStringBody = mStringBody;
    }

    public int getmIntPostId() {
        return mIntPostId;
    }

    public int getmIntId() {
        return mIntId;
    }

    public String getmStringName() {
        return mStringName;
    }

    public String getmStringEmail() {
        return mStringEmail;
    }

    public String getmStringBody() {
        return mStringBody;
    }
}

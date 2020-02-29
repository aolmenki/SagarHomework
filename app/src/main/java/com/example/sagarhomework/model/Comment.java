package com.example.sagarhomework.model;

import com.squareup.moshi.Json;

public class Comment {

    @Json(name = "postId") private int mIntPostId;
    @Json(name = "id") private int mIntId;
    @Json(name = "name") private String mStringName;
    @Json(name = "email") private String mStringEmail;
    @Json(name = "body") private String mStringBody;

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

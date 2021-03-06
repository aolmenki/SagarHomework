package com.example.sagarhomework.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class Post implements Parcelable{
    @Json(name = "userId") private int mIntUserId;
    @Json(name = "id") private int mIntPostId;
    @Json(name = "title") private String mStringTitle;
    @Json(name = "body") private String mStringBody;

    public Post(int pIntUserId, int pIntPostId, String pStringTitle, String pStringBody) {
        mIntUserId = pIntUserId;
        mIntPostId = pIntPostId;
        mStringTitle = pStringTitle;
        mStringBody = pStringBody;
    }

    public String getStringUser() {
        return "User" + mIntUserId;
    }

    public int getmIntPostId() {
        return mIntPostId;
    }

    public String getmStringTitle() {
        return mStringTitle;
    }

    public String getmStringBody() {
        return mStringBody;
    }

    /**
     * Parcelable Implementation
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mIntUserId);
        dest.writeInt(mIntPostId);
        dest.writeString(mStringTitle);
        dest.writeString(mStringBody);
    }

    public static final Parcelable.Creator<Post> CREATOR
            = new Parcelable.Creator<Post>() {

        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    private Post(Parcel in) {
        mIntUserId = in.readInt();
        mIntPostId = in.readInt();
        mStringTitle = in.readString();
        mStringBody = in.readString();
    }
}

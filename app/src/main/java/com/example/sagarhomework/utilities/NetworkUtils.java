package com.example.sagarhomework.utilities;

import com.example.sagarhomework.model.Post;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class NetworkUtils {

    NetworkUtils() {

    }

    public static Post[] loadAllPosts() {

        Moshi moshi = new Moshi.Builder().build();
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();

        Post[] listPosts = new Post[]{};

        AllPostsService service = retrofit.create(AllPostsService.class);
        try
        {
            Response<Post[]> posts = service.getAllPosts().execute();
            listPosts = posts.body();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return listPosts;
    }

    interface AllPostsService {
        @GET("posts")
        Call<Post[]> getAllPosts();
    }
}

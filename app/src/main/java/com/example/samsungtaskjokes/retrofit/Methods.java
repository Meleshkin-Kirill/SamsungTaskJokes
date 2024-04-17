package com.example.samsungtaskjokes.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Methods {
    @POST("/generate_jokes/")
    Call<RandomJoke> getRandomJoke();
}

package com.example.samsungtaskjokes.retrofit;

import com.example.samsungtaskjokes.CallBackJoke;

import java.sql.SQLOutput;

import javax.xml.transform.Source;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDatas {
    public void postDataGetRandomJoke(CallBackJoke result){
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<RandomJoke> call = methods.getRandomJoke();

        call.enqueue(new Callback<RandomJoke>() {
            @Override
            public void onResponse(Call<RandomJoke> call, Response<RandomJoke> response) {
                assert response.body() != null;
                result.invoke(response.body());
            }

            @Override
            public void onFailure(Call<RandomJoke> call, Throwable t) {
                System.out.println("trouble: " + t);
            }
        });
    }
}

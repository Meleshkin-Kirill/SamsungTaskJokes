package com.example.samsungtaskjokes.model;

import com.example.samsungtaskjokes.CallBack;
import com.example.samsungtaskjokes.CallBackJoke;
import com.example.samsungtaskjokes.retrofit.PostDatas;
import com.example.samsungtaskjokes.retrofit.RandomJoke;

public class MainActivityModel {
    private RandomJoke randomJokeMain;
    private final PostDatas postDatas = new PostDatas();

    public void getRandomJokeFromServer(CallBack callBack){
        postDatas.postDataGetRandomJoke(new CallBackJoke() {
            @Override
            public void invoke(RandomJoke randomJoke) {
                randomJokeMain = randomJoke;
                callBack.invoke();
            }
        });
    }

    public RandomJoke getRandomJoke(){
        return randomJokeMain;
    }
}

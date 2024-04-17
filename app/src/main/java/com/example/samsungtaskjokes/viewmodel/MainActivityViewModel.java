package com.example.samsungtaskjokes.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.samsungtaskjokes.CallBack;
import com.example.samsungtaskjokes.model.MainActivityModel;
import com.example.samsungtaskjokes.retrofit.RandomJoke;

public class MainActivityViewModel extends ViewModel {
    MainActivityModel model = new MainActivityModel();

    MutableLiveData<RandomJoke> randomJokeMutableLiveData;

    public LiveData<RandomJoke> getRandomJoke(){
        if(randomJokeMutableLiveData == null){
            randomJokeMutableLiveData = new MutableLiveData<>();
        }
        return randomJokeMutableLiveData;
    }

    public void getRandomJokeFromServer(CallBack callBack){
        model.getRandomJokeFromServer(new CallBack() {
            @Override
            public void invoke() {
                setRandomJokeMutableLiveData(callBack);
            }
        });
    }

    private void setRandomJokeMutableLiveData(CallBack callBack){
        randomJokeMutableLiveData.setValue(model.getRandomJoke());
        callBack.invoke();
    }
}

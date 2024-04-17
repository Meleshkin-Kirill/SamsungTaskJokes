package com.example.samsungtaskjokes.retrofit;

import com.google.gson.annotations.SerializedName;

public class RandomJoke {
    @SerializedName("tp")
    private String tp;
    @SerializedName("pn")
    private String pn;
    @SerializedName("stp")
    private String stp;
    @SerializedName("id")
    private int id;

    public RandomJoke(String tp, String pn, String stp, int id) {
        this.tp = tp;
        this.pn = pn;
        this.stp = stp;
        this.id = id;
    }

    public String getTp() {
        return tp;
    }

    public String getPn() {
        return pn;
    }

    public String getStp() {
        return stp;
    }

    public int getId() {
        return id;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public void setStp(String stp) {
        this.stp = stp;
    }

    public void setId(int id) {
        this.id = id;
    }
}

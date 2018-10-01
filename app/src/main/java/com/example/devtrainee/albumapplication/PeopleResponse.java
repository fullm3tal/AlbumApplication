package com.example.devtrainee.albumapplication;

import com.example.devtrainee.albumapplication.pojo.People;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleResponse {

    @SerializedName("results") private List<People> peopleList;

    public List<People> getList() {
        return peopleList;
    }
}

package com.example.devtrainee.albumapplication;

import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PeopleService{

    @GET
    io.reactivex.Observable<PeopleResponse> getPeopleResponse(@Url String url);

}

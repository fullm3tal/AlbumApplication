package com.example.devtrainee.albumapplication;

import retrofit2.http.GET;

public interface PeopleService{

    @GET
    io.reactivex.Observable<PeopleResponse> getPeopleResponse(String url);

}

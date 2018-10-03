package com.example.devtrainee.albumapplication;

import com.example.devtrainee.albumapplication.pojo.People;

import java.util.concurrent.ThreadPoolExecutor;

public class Response {

    public Status status;

    public People data;

    public Throwable error;

    public Response(Status status, People data, Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Response Loading(){
        return new Response(status,null,null);
    }

    public Response success(People data){
        return new Response(status,data,null);
    }

    public Response error(Throwable error){
        return new Response(status,null,error);
    }

}

package com.example.devtrainee.albumapplication;

import android.content.Context;
import android.databinding.BaseObservable;

public class ItemPeopleViewModel extends BaseObservable{

    People people;
    Context context;

    public ItemPeopleViewModel(People people, Context context) {
        this.people = people;
        this.context = context;
    }

    public String getName(){
        return people.getName();
    }
    public String getEmail(){
        return people.getEmail();
    }

    public String getPhoneNumber(){
        return String.valueOf(people.getPhoneNumber());
    }


}

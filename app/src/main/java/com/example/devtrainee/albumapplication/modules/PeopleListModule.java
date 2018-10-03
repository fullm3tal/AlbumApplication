package com.example.devtrainee.albumapplication.modules;

import com.example.devtrainee.albumapplication.PeopleViewModelScope;
import com.example.devtrainee.albumapplication.pojo.People;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

//@Module
public class PeopleListModule {
//    @Provides
//    @PeopleViewModelScope
    List<People> getPeopleList(){
        return new ArrayList<People>();
    }

}

package com.example.devtrainee.albumapplication.modules;

import android.databinding.ObservableInt;
import android.view.View;

import com.example.devtrainee.albumapplication.PeopleViewModelScope;

import dagger.Module;
import dagger.Provides;

//@Module
public class ObservableIntModule {
//
//    @Provides
//    @PeopleViewModelScope
   public ObservableInt getObservableInt(int visibility){
        return new ObservableInt(visibility);
    }
//
//    @Provides
//    @PeopleViewModelScope
    public int getVisibilityGone(){
        return View.GONE ;
    }

}

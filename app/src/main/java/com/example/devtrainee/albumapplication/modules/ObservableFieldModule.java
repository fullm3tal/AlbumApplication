package com.example.devtrainee.albumapplication.modules;

import android.content.Context;
import android.databinding.ObservableField;

import com.example.devtrainee.albumapplication.PeopleViewModelScope;
import com.example.devtrainee.albumapplication.R;

import dagger.Module;
import dagger.Provides;

//@Module(includes = {ActivityContextModule.class})
public class ObservableFieldModule {

// @Provides
// @PeopleViewModelScope
 ObservableField<String > observableField(String message){
     return new ObservableField<String>(message);
 }

// @Provides
// @PeopleViewModelScope
 String message(Context context){
     return context.getString(R.string.default_loading_people);
 }

}

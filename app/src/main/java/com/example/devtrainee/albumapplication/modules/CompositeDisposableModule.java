package com.example.devtrainee.albumapplication.modules;

import com.example.devtrainee.albumapplication.PeopleViewModelScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

//@Module
public class CompositeDisposableModule {
//
//    @Provides
//    @PeopleViewModelScope
    CompositeDisposable compositeDisposable(){
        return new CompositeDisposable();
    }

}

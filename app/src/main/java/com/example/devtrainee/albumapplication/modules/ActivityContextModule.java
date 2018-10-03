package com.example.devtrainee.albumapplication.modules;

import android.content.Context;

import com.example.devtrainee.albumapplication.PeopleViewModelScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityContextModule {

    private final Context context;

    public ActivityContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @PeopleViewModelScope
    Context getContext() {
        return context;
    }
}

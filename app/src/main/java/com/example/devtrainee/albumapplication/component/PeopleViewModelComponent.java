package com.example.devtrainee.albumapplication.component;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.example.devtrainee.albumapplication.modules.ActivityContextModule;
import com.example.devtrainee.albumapplication.modules.CompositeDisposableModule;
import com.example.devtrainee.albumapplication.modules.ObservableFieldModule;
import com.example.devtrainee.albumapplication.modules.ObservableIntModule;
import com.example.devtrainee.albumapplication.modules.PeopleListModule;
import com.example.devtrainee.albumapplication.pojo.People;

import java.util.List;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

//@Component(modules = {ObservableIntModule.class,
//        ActivityContextModule.class,
//        PeopleListModule.class,
//         CompositeDisposableModule.class,
//        ObservableFieldModule.class})

public interface PeopleViewModelComponent {

    ObservableInt getObservableInt();

    List<People> getPeopleList();

    CompositeDisposable getCompositeDisposable();

    Context getContext();

    ObservableField<String> getObservableField();

}

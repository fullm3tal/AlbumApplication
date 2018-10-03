package com.example.devtrainee.albumapplication.component;

import com.example.devtrainee.albumapplication.PeopleFactory;

import dagger.Component;

@Component
public interface AlbumAppComponent {

    PeopleFactory getPeopleFatory();


}

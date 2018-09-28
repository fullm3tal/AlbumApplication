package com.example.devtrainee.albumapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.devtrainee.albumapplication.databinding.ActivityPeopleBinding;

public class PeopleActivity extends AppCompatActivity {

    ActivityPeopleBinding binding;
    PeopleViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }

    private void initDataBinding() {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_people);
        peopleViewModel= new PeopleViewModel(this);
        binding.setPeopleViewModel(peopleViewModel);
    }
}

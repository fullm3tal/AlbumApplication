package com.example.devtrainee.albumapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.devtrainee.albumapplication.databinding.ActivityPeopleBinding;
import com.example.devtrainee.albumapplication.pojo.People;
import com.example.devtrainee.albumapplication.viewmodel.PeopleAdapter;
import com.example.devtrainee.albumapplication.viewmodel.PeopleViewModel;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PeopleActivity extends AppCompatActivity implements Observer {

    ActivityPeopleBinding binding;
    PeopleViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setUpRecyclerList(binding.rvPeople);
        setUpObserver(peopleViewModel);
    }

    private void setUpRecyclerList(RecyclerView rvPeople) {

        PeopleAdapter peopleAdapter = new PeopleAdapter(peopleViewModel.getPeopleList());
        rvPeople.setAdapter(peopleAdapter);
        rvPeople.setLayoutManager(new LinearLayoutManager(this));

    }


    private void setUpObserver(PeopleViewModel peopleViewModel) {
        peopleViewModel.addObserver(this);
    }

    private void initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people);
        peopleViewModel = new PeopleViewModel(this);
        binding.setPeopleViewModel(peopleViewModel);
        binding.setFabClick(peopleViewModel);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof PeopleViewModel) {
            PeopleAdapter adapter = (PeopleAdapter) binding.rvPeople.getAdapter();
            PeopleViewModel model = (PeopleViewModel) observable;
            adapter.setPeopleList(model.getPeopleList());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        peopleViewModel.reset();
    }

}

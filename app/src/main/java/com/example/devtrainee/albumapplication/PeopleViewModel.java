package com.example.devtrainee.albumapplication;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;

public class PeopleViewModel extends Observable implements FabClick{

  ObservableInt peopleProgressBar;
  ObservableInt peopleRecycler;
  List<People>  peopleList;
  ObservableInt peopleLabel;
  ObservableField<String> messageLabel;
  Context context;
  CompositeDisposable disposable=new CompositeDisposable();

  public PeopleViewModel(Context context) {
    this.peopleProgressBar = new ObservableInt(View.GONE);
    this.peopleRecycler = new ObservableInt(View.GONE);
    this.peopleList = new ArrayList<>();
    this.peopleLabel = new ObservableInt(View.VISIBLE);
    this.context = context;
    this.messageLabel = new ObservableField<>(context.getString(
            R.string.default_loading_people));
  }

  @Override
  public void onClickFabLoad() {
    initializeViews();
    fetchPeopleList();
  }

  private void fetchPeopleList() {
    Toast.makeText(context,"List is Here",Toast.LENGTH_SHORT).show();
  }

  private void initializeViews() {
  peopleProgressBar.set(View.VISIBLE);
  peopleLabel.set(View.GONE);
  peopleRecycler.set(View.GONE);
  }

}

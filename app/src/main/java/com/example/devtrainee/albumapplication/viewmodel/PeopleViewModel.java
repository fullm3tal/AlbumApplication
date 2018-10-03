package com.example.devtrainee.albumapplication.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import com.example.devtrainee.albumapplication.FabClick;
import com.example.devtrainee.albumapplication.PeopleFactory;
import com.example.devtrainee.albumapplication.PeopleResponse;
import com.example.devtrainee.albumapplication.PeopleService;
import com.example.devtrainee.albumapplication.R;
import com.example.devtrainee.albumapplication.pojo.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PeopleViewModel extends Observable implements FabClick {

    ObservableInt peopleProgressBar;
    ObservableInt peopleRecycler;
    List<People> peopleList;

    ObservableInt peopleLabelVisibility;
    ObservableField<String> messageLabel;
    Context context;
    CompositeDisposable disposable = new CompositeDisposable();

    public PeopleViewModel(Context context) {
        this.peopleProgressBar = new ObservableInt(View.GONE);
        this.peopleRecycler = new ObservableInt(View.GONE);
        this.peopleList = new ArrayList<>();
        this.peopleLabelVisibility = new ObservableInt(View.VISIBLE);
        this.context = context;
        this.messageLabel = new ObservableField<>(context.getString(
                R.string.default_loading_people));
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public ObservableInt getPeopleProgressBar() {
        return peopleProgressBar;
    }

    public ObservableInt getPeopleLabelVisibility() {
        return peopleLabelVisibility;
    }

    public ObservableField<String> getMessageLabel() {
        return messageLabel;
    }

    private void fetchPeopleList() {
        PeopleService peopleService = PeopleFactory.getInstance();
        disposable.add(peopleService.getPeopleResponse(PeopleFactory.RANDOM_USER_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<PeopleResponse>() {
                    @Override
                    public void onNext(PeopleResponse peopleResponse) {
                        peopleProgressBar.set(View.GONE);
                        peopleRecycler.set(View.VISIBLE);
                        changePeopleDataSet(peopleResponse.getList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        peopleRecycler.set(View.GONE);
                        peopleProgressBar.set(View.GONE);
                        Toast.makeText(context, e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    private void changePeopleDataSet(List<People> list) {
        peopleList.addAll(list);
        setChanged();
        notifyObservers();
    }

    private void initializeViews() {
        peopleProgressBar.set(View.VISIBLE);
        peopleLabelVisibility.set(View.GONE);
        peopleRecycler.set(View.GONE);
    }

    @Override
    public void onClickFabLoad() {
        initializeViews();
        fetchPeopleList();
    }

    public void reset() {
        if (!disposable.isDisposed() && !(disposable == null)) {
            disposable.dispose();
        }
        disposable = null;
        context = null;
    }
}
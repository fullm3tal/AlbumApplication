package com.example.devtrainee.albumapplication;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import com.example.devtrainee.albumapplication.pojo.People;



public class PeopleDetailViewModel extends ViewModel {

public static Intent launchDetail(Context context, People people){
    Intent intent= new Intent(context,PDetail_activity.class);
    intent.putExtra("EXTRA_PEOPLE",people);
    return intent;
}



}

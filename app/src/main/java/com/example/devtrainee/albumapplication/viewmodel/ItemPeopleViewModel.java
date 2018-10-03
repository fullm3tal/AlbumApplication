package com.example.devtrainee.albumapplication.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.devtrainee.albumapplication.PeopleDetailViewModel;
import com.example.devtrainee.albumapplication.pojo.People;

public class ItemPeopleViewModel extends BaseObservable{

    People people;
    Context context;

    public ItemPeopleViewModel(People people, Context context) {
        this.people = people;
        this.context = context;
    }

    public String getName(){
        return people.getName().getFirst();
    }
    public String getEmail(){
        return people.getEmail();
    }

    public String getPhoneNumber(){
        return String.valueOf(people.getCell());
    }

    public String getPictureProfile(){
        return people.getPicture().getMedium();
    }

    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void onItemClick(){
    }

    public void setPeople(People people){
        this.people=people;
        notifyChange();
    }

}

package com.example.devtrainee.albumapplication.viewmodel;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.devtrainee.albumapplication.R;
import com.example.devtrainee.albumapplication.databinding.ItemPeopleBinding;
import com.example.devtrainee.albumapplication.pojo.People;

import java.util.Collections;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ItemPeopleViewHolder> {

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
        notifyDataSetChanged();
    }

    public List<People> peopleList;

    public PeopleAdapter(List<People> peopleList) {
        this.peopleList = Collections.EMPTY_LIST;
    }

    @NonNull
    @Override
    public ItemPeopleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemPeopleBinding itemPeopleBinding=DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_people,viewGroup,false);
        return new ItemPeopleViewHolder(itemPeopleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPeopleViewHolder itemPeopleViewHolder, int i) {
           itemPeopleViewHolder.bindPeople(peopleList.get(i));
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }


    public static class ItemPeopleViewHolder extends RecyclerView.ViewHolder{

    ItemPeopleBinding itemPeopleBinding;

        public ItemPeopleViewHolder( ItemPeopleBinding itemPeopleBinding) {
            super(itemPeopleBinding.clItemPeople);
            this.itemPeopleBinding = itemPeopleBinding;
        }

        public void bindPeople(People people){
            if(itemPeopleBinding.getItemPeopleViewModel()==null){
            itemPeopleBinding.setItemPeopleViewModel(new ItemPeopleViewModel(people,itemView.getContext()));
                    }
            else {
                itemPeopleBinding.getItemPeopleViewModel().setPeople(people);
            }
        }
    }

}

package com.example.rajulnahar.recyclerviewncardview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class DataList extends Fragment{

    List<Person> data;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    myAdapter adapter;

    public DataList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_list,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new myAdapter(getActivity());
        data = getData();
        adapter.setData(data);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void setData(Person current){
        this.data.add(current);
        adapter.notifyDataSetChanged();
    }

    public List<Person> getData(){
        List<Person> data = new ArrayList();

        String[] names = {"Mohit Sharma","Xyz Abc"};
        int[] ids = {93,91};

        for(int i = 0; i < names.length; i++){
            Person person = new Person(names[i],ids[i]);
            data.add(person);
        }

        return data;

    }

}

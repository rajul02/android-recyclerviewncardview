package com.example.rajulnahar.recyclerviewncardview;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Addperson extends Fragment implements View.OnClickListener{

    EditText name;
    EditText age;
    EditText gender;
    EditText phone;
    EditText address;
    EditText email;
    Button button;

    communicator comm;

    public Addperson() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_addperson,container,false);

        comm = (communicator) getActivity();

        name= (EditText) v.findViewById(R.id.name);
        age= (EditText) v.findViewById(R.id.age);
        gender= (EditText) v.findViewById(R.id.gender);
        phone= (EditText) v.findViewById(R.id.phone);
        address= (EditText) v.findViewById(R.id.address);
        email= (EditText) v.findViewById(R.id.email);
        button= (Button) v.findViewById(R.id.button);
        button.setOnClickListener(this);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onClick(View v) {
        String pname = name.getText().toString();
        String page=age.getText().toString();
        String pgender=gender.getText().toString();
        String pphone= phone.getText().toString();
        String paddress=address.getText().toString();
        String pemail=email.getText().toString();
        String[] data ={pname,page,pgender,pphone,paddress,pemail};
        comm.respond(data);

        DataList dataList = new DataList();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentid,dataList);
        transaction.commit();

    }

    public interface communicator{
        public void respond(String[] data);
    }

/*
    @Override
    public void onClick(View v) {
        name= (EditText)name.getText();
        age=(EditText)age.getText();
        gender=(EditText)gender.getText();
    }*/
}

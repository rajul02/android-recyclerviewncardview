package com.example.rajulnahar.recyclerviewncardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Rajul Nahar on 21-May-16.
 */
public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    LayoutInflater inflater;
    List<Person> data;

    myAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.person_card,viewGroup,false);
        myViewHolder holder = new myViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder myViewHolder, int i) {
        Person current = data.get(i);
        myViewHolder.iv.setImageResource(R.drawable.logo);
        myViewHolder.tvname.setText(current.getName());
        myViewHolder.tvid.setText(String.valueOf(current.getImageid()));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView iv;
        TextView tvname;
        TextView tvid;

        public myViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.imageView);
            tvname = (TextView) itemView.findViewById(R.id.textViewname);
            tvid = (TextView) itemView.findViewById(R.id.textViewid);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            Toast.makeText(v.getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();

        }
    }

    public void setData(List<Person> data){
        this.data = data;
    }
}

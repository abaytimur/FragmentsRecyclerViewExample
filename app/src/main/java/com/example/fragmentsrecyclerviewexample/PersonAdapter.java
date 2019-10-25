package com.example.fragmentsrecyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> //bu adapter class'ini actiktan sonra ilk is extends RecyclerView.Adapter kismini yazip implement etmek oldu. asagidaki 3 metod kendiliginden geldi. <PersonAdapter.ViewHolder> bu kismi daha sonradan yazdik
{

    private ArrayList<Person> people;

    ItemClicked activity;


    public interface ItemClicked
    {
        void OnItemClicked(int index);
    }

    public PersonAdapter (Context context, ArrayList<Person> list)
    {
        people = list;
        activity = (ItemClicked) context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.OnItemClicked(people.indexOf((Person) view.getTag())); //OnItemClicked'in icindekiler indexi mainactivitydeki OnItemClicked'e indexi yollamak icin yazildi


                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int position) {

        viewHolder.itemView.setTag(people.get(position));

        viewHolder.tvName.setText(people.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}

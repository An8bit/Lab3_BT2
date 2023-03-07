package com.example.nguyenthanhan17_lab3bt2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryVH>  {
    ArrayList<Country> countries;
    Listener listener;
    public CountryAdapter(Listener listener,ArrayList<Country> countries) {
        this.listener=listener;
        this.countries = countries;
    }
    @NonNull
    @Override
    public CountryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contry_cell, parent,false);
        return new CountryVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CountryVH holder, int position) {
        Country country = countries.get(position);
        holder.imgFlag.setImageResource(country.getImage());
        holder.txName.setText(country.getName());
        holder.txCapital.setText("Capital: ".concat(country.getCapital()));
        NumberFormat numberFormatter = NumberFormat.getInstance(Locale.US);
        numberFormatter.setMinimumFractionDigits(2);
        holder.txDescription.setText(country.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(country);

            }
        });
    }
    @Override
    public int getItemCount() {
        return countries.size();
    }


    class CountryVH extends RecyclerView.ViewHolder{
        CircleImageView imgFlag;
        TextView txName, txCapital, txDescription;

        public CountryVH(@NonNull View itemView) {
            super(itemView);
            imgFlag = itemView.findViewById(R.id.imgFlag);
            txName = itemView.findViewById(R.id.txName);
            txCapital = itemView.findViewById(R.id.txCapital);
            txDescription = itemView.findViewById(R.id.txDescription);
        }
    }
    interface Listener{
        void onItemClickListener(Country country);
    }

}






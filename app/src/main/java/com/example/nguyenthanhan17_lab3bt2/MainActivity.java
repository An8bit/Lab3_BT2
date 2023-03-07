package com.example.nguyenthanhan17_lab3bt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CountryAdapter.Listener {

    RecyclerView rvCountries;
    ArrayList<Country> countries;

    CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCountries = findViewById(R.id.rvCountries);
        countries = App.initDataForCountry();
        countryAdapter = new CountryAdapter(MainActivity.this,countries);

        rvCountries.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rvCountries.setAdapter(countryAdapter);

    }



    @Override
    public void onItemClickListener(Country country) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(country.getName());
        builder.setIcon(getDrawable(country.getImage()));
        builder.setMessage("Population: "+country.getPopulation()+ "\n"+"LAT: "+country.getLatitude()+"\n"+"LONG: "+country.getLongitude());

        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
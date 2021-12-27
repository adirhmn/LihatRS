package com.adi.lihatrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.adi.lihatrs.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PilihKotaKab extends AppCompatActivity {

    private RecyclerView rvCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kota_kab);

        String id_province=getIntent().getStringExtra("id_province");

        ApiService.endPoint().getCities(id_province)
                .enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        List<Model.Cities> citiesList=response.body().getCities();

                        rvCities=findViewById(R.id.rv_cities);
                        rvCities.setHasFixedSize(true);
                        rvCities.setLayoutManager(new LinearLayoutManager(PilihKotaKab.this, LinearLayoutManager.VERTICAL, false));
                        CitiesAdapter citiesAdapter=new CitiesAdapter(citiesList, id_province);
                        rvCities.setAdapter(citiesAdapter);
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.d("PilihKotaKab", t.toString());
                    }
                });

    }
}
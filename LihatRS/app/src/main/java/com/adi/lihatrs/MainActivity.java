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

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvProvinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService.endPoint().getProvinces()
                .enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        List<Model.Provinces> provincesList=response.body().getProvinces();

                        rvProvinces=findViewById(R.id.rv_provinces);
                        rvProvinces.setHasFixedSize(true);
                        rvProvinces.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                        ProvincesAdapter provincesAdapter=new ProvincesAdapter(provincesList);
                        rvProvinces.setAdapter(provincesAdapter);

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.d("MainActivity", t.toString());
                    }
                });

    }
}
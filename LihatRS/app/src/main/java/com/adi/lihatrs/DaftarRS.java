package com.adi.lihatrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.adi.lihatrs.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarRS extends AppCompatActivity {

    private RecyclerView rvDaftarRS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_rs);

        String id_city= getIntent().getStringExtra("id_city");
        String id_province=getIntent().getStringExtra("id_province");

        ApiService.endPoint().getHospitals(id_province, id_city, "2")
                .enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        List<Model.Hospitals> hospitalsList=response.body().getHospitals();
                        Log.d("Daftar RS", response.toString());

                        rvDaftarRS=findViewById(R.id.rv_daftar_rs);
                        rvDaftarRS.setHasFixedSize(true);
                        rvDaftarRS.setLayoutManager(new LinearLayoutManager(DaftarRS.this, LinearLayoutManager.VERTICAL, false));
                        HospitalsAdapter hospitalsAdapter=new HospitalsAdapter(hospitalsList);
                        rvDaftarRS.setAdapter(hospitalsAdapter);
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.d("Daftar RS", t.toString());
                    }
                });
    }
}
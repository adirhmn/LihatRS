package com.adi.lihatrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adi.lihatrs.retrofit.ApiService;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailRS extends AppCompatActivity implements OnMapReadyCallback {

    private ImageView btnBack;
    private TextView detailName, detailTotalBed, detailBedroom, detailRoomname, detailTelp, detailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rs);

        btnBack=findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        detailName=findViewById(R.id.detail_name);
        detailTotalBed=findViewById(R.id.detail_total_bed);
        detailBedroom=findViewById(R.id.detail_bedroom);
        detailRoomname=findViewById(R.id.detail_nameroom);
        detailTelp=findViewById(R.id.detail_telp);
        detailAddress=findViewById(R.id.detail_address);

        detailName.setText(getIntent().getStringExtra("name"));
        detailTotalBed.setText(String.valueOf(getIntent().getIntExtra("available", 0)));
        detailBedroom.setText(getIntent().getStringExtra("bed_class"));
        detailRoomname.setText(getIntent().getStringExtra("room_name"));
        detailTelp.setText(getIntent().getStringExtra("telp"));
        detailAddress.setText(getIntent().getStringExtra("address"));

    }


    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        String hospitalid=getIntent().getStringExtra("id");
        Log.d("id hospital", hospitalid);

        ApiService.endPoint().getHospitalMap(hospitalid)
                .enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Model.Data mapHospital=response.body().getData();
                        Log.d("DetailRS", response.toString());
                        String lat=mapHospital.getLat();
                        String lon=mapHospital.getLon();
                        String name=mapHospital.getName();

                        map.addMarker(new MarkerOptions().position(new LatLng(Double.valueOf(lat), Double.valueOf(lon))).title(name));
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });

    }
}
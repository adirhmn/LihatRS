package com.adi.lihatrs.retrofit;

import com.adi.lihatrs.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("get-provinces")
    Call<Model> getProvinces();

    @GET("get-cities")
    Call<Model> getCities(@Query("provinceid") String provinceid);

    @GET("get-hospitals")
    Call<Model> getHospitals(@Query("provinceid") String provinceid,
                             @Query("cityid") String cityid,
                             @Query("type") String type);

    @GET("get-bed-detail")
    Call<Model> getBedDetail(@Query("hospitalid") String hospitalid,
                             @Query("type") String type);

    @GET("get-hospital-map")
    Call<Model> getHospitalMap(@Query("hospitalid") String hospitalid);
}

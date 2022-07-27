/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.repository;

import com.dot.test.dto.CityDTO;
import com.dot.test.dto.ProvinceDTO;
import com.dot.test.dto.RajaOngkirResponse;
import com.dot.test.utils.ProvinceMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public class CityRepository {

    public RajaOngkirResponse<List<CityDTO>> findAll() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.rajaongkir.com/starter/city")
                .get()
                .addHeader("key", "47cb54927ed5fe60b0066e50909de571")
                .build();

        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        RajaOngkirResponse<List<CityDTO>> res = gson.fromJson(response.body().string(), RajaOngkirResponse.class);
        return res;
    }

    public RajaOngkirResponse findById(String id) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.rajaongkir.com/starter/city?id=" + id)
                .get()
                .addHeader("key", "47cb54927ed5fe60b0066e50909de571")
                .build();

        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        String responseData = response.body().string();
        RajaOngkirResponse res = gson.fromJson(responseData, RajaOngkirResponse.class);
        return res;
    }
}

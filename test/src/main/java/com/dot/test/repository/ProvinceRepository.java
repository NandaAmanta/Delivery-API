/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.repository;

import com.dot.test.dto.ProvinceDTO;
import com.dot.test.dto.RajaOngkirResponse;
import com.dot.test.utils.ProvinceMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public class ProvinceRepository {

    public RajaOngkirResponse<List<ProvinceDTO>> findAll() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.rajaongkir.com/starter/province")
                .get()
                .addHeader("key", "47cb54927ed5fe60b0066e50909de571")
                .build();

        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        RajaOngkirResponse<List<ProvinceDTO>> res = gson.fromJson(response.body().string(), RajaOngkirResponse.class);
        return res;
    }

//    public ProvinceDTO findById(String id) {
//
//    }
}

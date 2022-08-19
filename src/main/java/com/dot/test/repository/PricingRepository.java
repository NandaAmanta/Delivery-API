/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.repository;

import com.dot.test.dto.CourierDTO;
import com.dot.test.dto.ProvinceDTO;
import com.dot.test.dto.RajaOngkirResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public class PricingRepository {

    @Value("${key.rajaongkir}")
    private String key;

    @Value("${url.rajaongkir}")
    private String urlRajaongkir;

    public RajaOngkirResponse getPricing(int originCityId, int destinationCityId, int packageWeight, String courier) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String data = String.format("origin=%o&destination=%o&weight=%o&courier=%s", originCityId, destinationCityId, packageWeight, courier);
        System.out.println(data);
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(data, mediaType);
        Request request = new Request.Builder()
                .url(urlRajaongkir + "/cost")
                .post(body)
                .addHeader("key", key)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        Response response = client.newCall(request).execute();
        var responseString = response.body().string();
        Gson gson = new Gson();
        RajaOngkirResponse res = gson.fromJson(responseString, RajaOngkirResponse.class);
        return res;
    }
;
}

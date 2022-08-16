package com.dot.test.utils;

import com.dot.test.dto.ProvinceDTO;
import com.dot.test.dto.RajaOngkirResponse;
import java.util.List;
import javax.annotation.processing.Generated;
import okhttp3.ResponseBody;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T12:03:26+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class ProvinceMapperImpl implements ProvinceMapper {

    @Override
    public RajaOngkirResponse<ProvinceDTO> toRajaOngkirResponseProvince(ResponseBody responseBody) {
        if ( responseBody == null ) {
            return null;
        }

        RajaOngkirResponse<ProvinceDTO> rajaOngkirResponse = new RajaOngkirResponse<ProvinceDTO>();

        return rajaOngkirResponse;
    }

    @Override
    public RajaOngkirResponse<List<ProvinceDTO>> toRajaOngkirResponseListProvinces(ResponseBody responseBody) {
        if ( responseBody == null ) {
            return null;
        }

        RajaOngkirResponse<List<ProvinceDTO>> rajaOngkirResponse = new RajaOngkirResponse<List<ProvinceDTO>>();

        return rajaOngkirResponse;
    }
}

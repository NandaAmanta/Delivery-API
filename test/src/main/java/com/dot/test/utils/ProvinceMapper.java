/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.utils;

import com.dot.test.dto.OrderDTO;
import com.dot.test.dto.ProvinceDTO;
import com.dot.test.dto.RajaOngkirResponse;
import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.model.Order;
import com.dot.test.model.User;
import java.util.List;
import okhttp3.ResponseBody;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author ASUS
 */
@Mapper
public interface ProvinceMapper {

    ProvinceMapper INSTANCE = Mappers.getMapper(ProvinceMapper.class);

    RajaOngkirResponse<ProvinceDTO> toRajaOngkirResponseProvince(ResponseBody responseBody);

    RajaOngkirResponse<List<ProvinceDTO>> toRajaOngkirResponseListProvinces(ResponseBody responseBody);
}

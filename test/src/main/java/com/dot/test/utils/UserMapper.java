/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.utils;

import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserUpdateDTO;
import com.dot.test.model.User;
import java.util.List;
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
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserCreationDTO userCreationDTO);

    User toDomain(UserDTO userDTO);
    
    User toDomain(UserUpdateDTO userUpdateDTO);

    @Named("toDTO")
    UserDTO userToUserDTO(User user);

    @IterableMapping(qualifiedByName = "toDTO")
    List<UserDTO> usersToUserDTOs(List<User> user);
}

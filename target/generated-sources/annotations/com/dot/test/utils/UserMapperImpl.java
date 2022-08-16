package com.dot.test.utils;

import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserUpdateDTO;
import com.dot.test.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T12:03:27+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDomain(UserCreationDTO userCreationDTO) {
        if ( userCreationDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFullName( userCreationDTO.getFullName() );
        user.setEmail( userCreationDTO.getEmail() );
        user.setPassword( userCreationDTO.getPassword() );
        user.setPhoneNumber( userCreationDTO.getPhoneNumber() );

        return user;
    }

    @Override
    public User toDomain(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setFullName( userDTO.getFullName() );
        user.setEmail( userDTO.getEmail() );
        user.setPhoneNumber( userDTO.getPhoneNumber() );

        return user;
    }

    @Override
    public User toDomain(UserUpdateDTO userUpdateDTO) {
        if ( userUpdateDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFullName( userUpdateDTO.getFullName() );
        user.setPassword( userUpdateDTO.getPassword() );
        user.setPhoneNumber( userUpdateDTO.getPhoneNumber() );

        return user;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setFullName( user.getFullName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPhoneNumber( user.getPhoneNumber() );

        return userDTO;
    }

    @Override
    public List<UserDTO> usersToUserDTOs(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( user.size() );
        for ( User user1 : user ) {
            list.add( userToUserDTO( user1 ) );
        }

        return list;
    }
}

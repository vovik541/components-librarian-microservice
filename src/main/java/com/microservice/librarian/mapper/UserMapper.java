package com.microservice.librarian.mapper;

import com.microservice.librarian.entity.User;
import com.microservice.librarian.entity.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO userToUserDTO(User user);
}

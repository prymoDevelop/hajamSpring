package com.prymodev.mapper;


import com.prymodev.DTO.UserDTO;
import com.prymodev.entity.AppUser;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends IEntityMapper<UserDTO, AppUser> {

}
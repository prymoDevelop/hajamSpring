package com.prymodev.barberAPI.domain.mapper;


import com.prymodev.barberAPI.domain.DTO.UserDTO;
import com.prymodev.barberAPI.domain.entity.AppUser;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends IEntityMapper<UserDTO, AppUser> {

}
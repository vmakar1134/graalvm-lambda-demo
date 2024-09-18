package com.makar.graalvmdemo.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.makar.graalvmdemo.entity.User;
import com.makar.graalvmdemo.model.UserResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    UserResponse toResponse(User user);

    List<UserResponse> toResponse(List<User> users);

}

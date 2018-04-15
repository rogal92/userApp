package com.users.app.mapper;

import com.users.app.domain.User;
import com.users.app.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getBirthday(),
                userDto.getUsersGroupList());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                user.getBirthday(),
                user.getUsersGroupList());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(user -> new UserDto(user.getId(),user.getName(),user.getPassword(),user.getFirstname(),user.getLastname(),
                        user.getBirthday(),user.getUsersGroupList()))
                .collect(Collectors.toList());
    }
}

package com.users.app.mapper;

import com.users.app.domain.GroupOfUsers;
import com.users.app.domain.GroupOfUsersDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupOfusersMapper {
    public GroupOfUsers mapToGroupOfUsers(final GroupOfUsersDto groupOfUsersDto) {
        return new GroupOfUsers(
                groupOfUsersDto.getId(),
                groupOfUsersDto.getName(),
                groupOfUsersDto.getUserList());
    }
    public GroupOfUsersDto mapToGroupOfUsersDto(final GroupOfUsers groupOfUsers) {
        return new GroupOfUsersDto(
                groupOfUsers.getId(),
                groupOfUsers.getName(),
                groupOfUsers.getUserList());
    }
    public List<GroupOfUsersDto> mapToGroupOfUsersDto(final List<GroupOfUsers> groupOfUsersList) {
        return groupOfUsersList.stream()
                .map(groupOfUsers -> new GroupOfUsersDto(groupOfUsers.getId(),groupOfUsers.getName(),groupOfUsers.getUserList()))
                .collect(Collectors.toList());
    }
}
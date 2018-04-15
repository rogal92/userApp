package com.users.app.controller;

import com.users.app.domain.GroupOfUsers;
import com.users.app.domain.GroupOfUsersDto;
import com.users.app.domain.User;
import com.users.app.domain.UserDto;
import com.users.app.mapper.GroupOfusersMapper;
import com.users.app.mapper.UsersMapper;
import com.users.app.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class UsersController {

    @Autowired
    DbService dbService;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    GroupOfusersMapper groupOfusersMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers() {
        return dbService.getAllUsers().stream()
                .map(u -> usersMapper.mapToUserDto(u))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public User getUserById(Long id) throws UserNotFoundException {
        return dbService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        dbService.saveUser(usersMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return usersMapper.mapToUserDto(dbService.saveUser(usersMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser(Long id) {
        dbService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/groupOfUsers")
    public List<GroupOfUsersDto> getAllGroups() {
        return dbService.getAllGroups().stream()
                .map(groupOfUsers -> new GroupOfUsersDto(groupOfUsers.getId(), groupOfUsers.getName(),groupOfUsers.getUserList()))
                .collect(Collectors.toList());
    }
    @RequestMapping(method = RequestMethod.GET, value = "/groupOfUsers{groupOfUsersId}")
    public GroupOfUsers getGroupById(Long id) throws GroupOfUsersNotFoundException {
        return dbService.getGroupById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/groupOfUsers",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupOfUsersDto groupOfUsersDto) {
        dbService.saveGroup(groupOfusersMapper.mapToGroupOfUsers(groupOfUsersDto));
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/groupOfUsers")
    public GroupOfUsersDto updateGroup(@RequestBody GroupOfUsersDto groupOfUsersDto) {
        return groupOfusersMapper.mapToGroupOfUsersDto(dbService.saveGroup(groupOfusersMapper.mapToGroupOfUsers(groupOfUsersDto)));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/groupOfUsers/{groupOfUsersId}")
    public void deleteGroup(Long id) {
        dbService.deleteGroup(id);
    }
}

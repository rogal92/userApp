package com.users.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String firstname;
    private String lastname;
    private Date birthday;
    private List<GroupOfUsers> usersGroupList;
}
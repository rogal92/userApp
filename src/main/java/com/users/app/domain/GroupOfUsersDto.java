package com.users.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GroupOfUsersDto {
    private Long id;
    private String name;
    private List<User> userList;
}

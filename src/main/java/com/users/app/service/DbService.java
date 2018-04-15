package com.users.app.service;

import com.users.app.controller.GroupOfUsersNotFoundException;
import com.users.app.controller.UserNotFoundException;
import com.users.app.domain.GroupOfUsers;
import com.users.app.domain.User;
import com.users.app.repository.GroupOfUsersRepository;
import com.users.app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private GroupOfUsersRepository groupOfUsersRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public List<GroupOfUsers> getAllGroups() {
        return groupOfUsersRepository.findAll();
    }
    public GroupOfUsers getGroupById(Long id) throws GroupOfUsersNotFoundException {
        return groupOfUsersRepository.findById(id).orElseThrow(GroupOfUsersNotFoundException::new);
    }
    public GroupOfUsers saveGroup(GroupOfUsers groupOfUsers) {
        return groupOfUsersRepository.save(groupOfUsers);
    }
    public void deleteGroup(Long id) {
        groupOfUsersRepository.deleteById(id);
    }
}

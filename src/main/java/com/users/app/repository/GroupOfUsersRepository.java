package com.users.app.repository;

import com.users.app.domain.GroupOfUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroupOfUsersRepository extends CrudRepository<GroupOfUsers,Long> {

    @Override
    List<GroupOfUsers> findAll();

    @Override
    Optional<GroupOfUsers> findById(Long id);

    @Override
    GroupOfUsers save(GroupOfUsers groupOfUsers);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}

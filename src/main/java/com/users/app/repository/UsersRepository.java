package com.users.app.repository;

import com.users.app.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User,Long> {

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long id);

    @Override
    List<User> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long id);
}

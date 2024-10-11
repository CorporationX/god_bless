package ru.kraiush.spring.BJS2_27254.service;

import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(long id);

    List<User> findAll();

    User create(User user);

    void update(User user);

    void deleteById(long id);

    void deleteAll();

    void  changeRole(User user, Role role);
}

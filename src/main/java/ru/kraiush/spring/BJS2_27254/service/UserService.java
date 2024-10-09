package ru.kraiush.spring.BJS2_27254.service;

import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(long id);

    List<User> findAll();

    User create(User user) throws Exception;

    void update(User user) throws Exception;

    void deleteById(long id) throws Exception;

    void deleteAll() throws Exception;

    void  changeRole(User use, Role role ) throws Exception;
}

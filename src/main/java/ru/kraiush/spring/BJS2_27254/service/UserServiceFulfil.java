package ru.kraiush.spring.BJS2_27254.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.User;
import ru.kraiush.spring.BJS2_27254.exception.UserException;
import ru.kraiush.spring.BJS2_27254.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.kraiush.spring.BJS2_27254.common.ConstantsUser.ErrorMessage.USER_ALREADY_EXISTS;
import static ru.kraiush.spring.BJS2_27254.common.ConstantsUser.ErrorMessage.USER_EMAIL_ALREADY_EXISTS;
import static ru.kraiush.spring.BJS2_27254.common.ConstantsUser.*;


@Service
@RequiredArgsConstructor
public class UserServiceFulfil implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceFulfil.class);

    private final UserRepository repository;

    @Override
    public List<User> findAll() {
        List<User> listMembers = repository.findAll();
        if (listMembers.isEmpty()) {
            log.info("No elements found!");
        } else {
            return listMembers.stream()
                    .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                    .collect(Collectors.toList());
        }
        return listMembers;
    }

    @Override
    public User findById(long id) {
        Optional<User> element = repository.findById(id);
        if (element.isPresent()) {
            return element.get();
        } else {
            throw new UserException(USER_GET_EXCEPTION);
        }
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User create(User user) {
        try {
            if (repository.existsByUsername(user.getUsername())) {
                throw new UserException(USER_ALREADY_EXISTS + user.getId());
            }
            if (repository.existsByEmail(user.getEmail())) {
                throw new UserException(USER_EMAIL_ALREADY_EXISTS + user.getId());
            }
            return save(user);
        } catch (final RuntimeException e) {
            throw new UserException(USER_CREATE_EXCEPTION, e);
        }
    }

    public User getByUsername(String username) {
        Optional<User> userOptional = repository.findByUsername(username);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            log.info("The user wasn't found!");
            return null;
        }
    }

    @Override
    public void update(User user) throws Exception {
        try {
            repository.save(user);
        } catch (final Exception e) {
            throw new UserException(USER_UPDATE_EXCEPTION, e);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (final Exception e) {
            throw new UserException(USER_DELETE_EXCEPTION, e);
        }
    }

    @Override
    public void deleteAll() throws Exception {
        try {
            repository.deleteAll();
        } catch (final Exception e) {
            throw new UserException(USER_DELETE_ALL_EXCEPTION, e);
        }
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}

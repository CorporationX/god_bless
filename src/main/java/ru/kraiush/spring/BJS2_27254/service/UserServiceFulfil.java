package ru.kraiush.spring.BJS2_27254.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.User;
import ru.kraiush.spring.BJS2_27254.exception.ElementAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.exception.ElementNotFoundException;
import ru.kraiush.spring.BJS2_27254.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                    .sorted(Comparator.comparing(User::getId))
                    .collect(Collectors.toList());
        }
        return listMembers;
    }

    @Override
    public User findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new ElementNotFoundException("NO USER PRESENT WITH ID = " + id));
    }

    public User create(User user) {
        User existingUser = repository.findByEmail(user.getEmail())
                .orElse(null);
        if (existingUser == null) {
            return repository.save(user);
        } else
            throw new ElementAlreadyExistsException("USER WITH SUCH EMAIL ALREADY EXISTS - " + user.getId());
    }

    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(
                        () -> new ElementNotFoundException("NO USER PRESENT WITH NAME - " + username));
    }

    @Override
    public void update(User user) {
        User existingUser = repository.findById(user.getId())
                .orElse(null);
        if (existingUser == null)
            throw new ElementNotFoundException("NO SUCH USER EXISTS!");
        else repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        User existingUser = repository.findById(id)
                .orElse(null);
        if (existingUser == null)
            throw new ElementNotFoundException("NO SUCH USER EXISTS!");
        else
            repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        List<User> listMembers = repository.findAll();
        if (listMembers.isEmpty()) {
            log.info("No elements for deleting found!");
        } else
            repository.deleteAll();
    }

    @Override
    public void changeRole(User user, Role role) {
        User existingUser = repository.findByUsername(user.getUsername())
                .orElse(null);
        if (existingUser == null)
            throw new ElementNotFoundException("NO SUCH USER EXISTS!");
        else {
            existingUser.setRole(role);
            repository.save(existingUser);
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
        repository.save(user);
    }
}

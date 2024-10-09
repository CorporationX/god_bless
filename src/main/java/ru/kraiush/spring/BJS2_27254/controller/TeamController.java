package ru.kraiush.spring.BJS2_27254.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.kraiush.spring.BJS2_27254.domain.dto.UserDto;
import ru.kraiush.spring.BJS2_27254.domain.model.User;
import ru.kraiush.spring.BJS2_27254.service.UserServiceFulfil;
import ru.kraiush.spring.BJS2_27254.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {

    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    private final UserServiceFulfil service;

    @Autowired
    public TeamController(UserServiceFulfil service) {
        this.service = service;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, Visitor!";
    }

    @GetMapping(value = "/members")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Get all users")
    public List<UserDto> findAll() {
        log.info("load All users");
        List<User> members = service.findAll();
        return MapperUtil.convertList(members, UserDto.class);
    }

    @GetMapping(value = "/members/{id}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Get a user by Id")
    public UserDto getUser(@PathVariable("id") long id) {
        log.info("load user by id: ", id);
        User member = service.findById(id);
        return MapperUtil.convertClass(member, UserDto.class);
    }

    @PostMapping(value = "/members")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a user")
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("create user: ", userDto);
        User user = MapperUtil.convertClass(userDto, User.class);
        User userCreated = service.create(user);
        return MapperUtil.convertClass(userCreated, UserDto.class);
    }

    @PutMapping(value = "/members/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update a user")
    public void updateUser(@RequestBody UserDto userDto) throws Exception {
        log.info("start update user: ", userDto);
        User user = MapperUtil.convertClass(userDto, User.class);
        service.update(user);
    }

    @DeleteMapping(value = "/members/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a user")
    public void delete(@PathVariable long id) throws Exception {
        service.deleteById(id);
    }

    @GetMapping("/members/admin")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Available only to authorized users with the ADMIN role")
    public String exampleAdmin() {
        return "Hello, admin!";
    }

    @GetMapping("/members/get-admin")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Get the ADMIN role")
    public void getAdmin() {
        service.getAdmin();
    }
}

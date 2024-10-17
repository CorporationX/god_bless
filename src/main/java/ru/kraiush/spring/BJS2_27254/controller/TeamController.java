package ru.kraiush.spring.BJS2_27254.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.kraiush.spring.BJS2_27254.config.context.UserContext;
import ru.kraiush.spring.BJS2_27254.domain.dto.TeamMemberDto;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.exception.DataValidationException;
import ru.kraiush.spring.BJS2_27254.service.TeamMemberServiceFulfil;
import ru.kraiush.spring.BJS2_27254.util.MapperUtil;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class TeamController {

    private final TeamMemberServiceFulfil service;
    private UserContext context;
    private Long userId;

    public TeamController(TeamMemberServiceFulfil service, UserContext context) {
        this.service = service;
        this.context = context;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, Visitor!";
    }

    @GetMapping(value = "/members")
    @Operation(summary = "Get all users")
    public List<TeamMemberDto> findAll() {
        userId = context.getUserId();
        if (userId == null) {
            log.info("No users Id found");
            return null;
        }
        String role = service.findRoleById(userId);
        if (role.equals("ROLE_USER") || role.equals("ROLE_OWNER") || role.equals("ROLE_TEAMLEAD")) {
            log.info("load All users");
            List<TeamMember> members = service.findAll();
            return MapperUtil.convertList(members, TeamMemberDto.class);
        } else
            throw new DataValidationException("ACCESS IS DENIED FOR SUCH A MEMBER ROLE = " + role);
    }

    @GetMapping(value = "/members/{id}")
    @Operation(summary = "Get a user by Id")
    public TeamMemberDto getTeamMember(@PathVariable("id") long id) throws AccessDeniedException {
        userId = context.getUserId();
        if (userId == null) {
            log.info("No users Id found");
            return null;
        }
        String role = service.findRoleById(userId);
        if (role.equals("ROLE_USER") || role.equals("ROLE_OWNER") || role.equals("ROLE_TEAMLEAD")) {
            log.info("load user by id: ", id);
            Optional<TeamMember> member = service.findById(id);
            return MapperUtil.convertClass(member.get(), TeamMemberDto.class);
        } else
            throw new AccessDeniedException("ACCESS IS DENIED FOR SUCH A MEMBER ROLE = " + role);
    }

    @PostMapping(value = "/members")
    @Operation(summary = "Create a user")
    public TeamMemberDto createTeamMember(@RequestBody TeamMemberDto userDto) {
        userId = context.getUserId();
        if (userId == null) {
            log.info("No users Id found");
            return null;
        }
        String role = service.findRoleById(userId);
        if (role.equals("ROLE_OWNER") || role.equals("ROLE_TEAMLEAD")) {
            log.info("create user: ", userDto);
            TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
            TeamMember userCreated = service.create(user);
            return MapperUtil.convertClass(userCreated, TeamMemberDto.class);
        } else
            throw new DataValidationException("ACCESS IS DENIED FOR SUCH A MEMBER ROLE = " + role);
    }

    @PutMapping(value = "/members")
    @Operation(summary = "Update a user")
    public TeamMemberDto updateTeamMember(@RequestBody TeamMemberDto userDto) {
        userId = context.getUserId();
        if (userId == null) {
            log.info("No users Id found");
            return null;
        }
        String role = service.findRoleById(userId);
        if (role.equals("ROLE_OWNER") || role.equals("ROLE_TEAMLEAD")) {
            log.info("start update user: ", userDto);
            TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
            TeamMember userUpdated = service.update(user);
            return MapperUtil.convertClass(userUpdated, TeamMemberDto.class);
        } else
            throw new DataValidationException("ACCESS IS DENIED FOR SUCH A MEMBER ROLE = " + role);
    }

    @DeleteMapping(value = "/members/{id}")
    @Operation(summary = "Delete a user")
    public void delete(@PathVariable long id) {
        userId = context.getUserId();
        if (userId == null) {
            log.info("No users Id found");
        }
        String role = service.findRoleById(userId);
        if (role.equals("ROLE_OWNER") || role.equals("ROLE_TEAMLEAD")) {
            service.deleteById(id);
        } else
            throw new DataValidationException("ACCESS IS DENIED FOR SUCH A MEMBER ROLE = " + role);
    }
}
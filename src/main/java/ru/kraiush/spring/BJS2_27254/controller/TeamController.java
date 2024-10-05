package ru.kraiush.spring.BJS2_27254.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kraiush.spring.BJS2_27254.dto.TeamMemberDto;
import ru.kraiush.spring.BJS2_27254.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.service.TeamMemberService;
import ru.kraiush.spring.BJS2_27254.service.proxy.TeamServiceInvocationHandler;
import ru.kraiush.spring.BJS2_27254.util.MapperUtil;

import java.lang.reflect.Proxy;
import java.util.List;

@RestController
@RequestMapping("/members")
public class TeamController {

    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    private final TeamMemberService service;

    @Autowired
    public TeamController(TeamMemberService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TeamMemberDto>> findAll() {
        log.info("start load All members");
        List<TeamMember> members = service.findAll();
//        return MapperUtil.convertList(members, TeamMemberDto.class);
        return ResponseEntity.ok().body(MapperUtil.convertList(members, TeamMemberDto.class));
    }

    @PostMapping
    public ResponseEntity<TeamMemberDto> createMember(@RequestBody @Valid TeamMemberDto memberDto, @Valid TeamMemberDto userDto)  {
        log.info("start creating member: ", memberDto);
        TeamMember member = MapperUtil.convertClass(memberDto, TeamMember.class);
        TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
        try {
            ClassLoader memberClassLoader = member.getClass().getClassLoader();
            Class[] interfaces = member.getClass().getInterfaces();
            TeamMemberService proxy = (TeamMemberService) Proxy.newProxyInstance(memberClassLoader, interfaces, new TeamServiceInvocationHandler(user));
            TeamMember memberCreated = proxy.create(member);
            return new ResponseEntity<>(MapperUtil.convertClass(memberCreated, TeamMemberDto.class), HttpStatus.CREATED);
        } catch (Exception e) {
            log.info("Exception Message::" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public TeamMemberDto getTeamMember(@PathVariable("id") long id) {
        log.info("start load member by id: ", id);
        TeamMember member = service.findById(id);
        return MapperUtil.convertClass(member, TeamMemberDto.class);
    }

    @PutMapping(value = "/{id}")
    public void updateTeamMember(@RequestBody @Valid TeamMemberDto memberDto, @Valid TeamMemberDto userDto) {
        log.info("start update member: ", memberDto);
        TeamMember member = MapperUtil.convertClass(memberDto, TeamMember.class);
        TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
        try {
            ClassLoader memberClassLoader = member.getClass().getClassLoader();
            Class[] interfaces = member.getClass().getInterfaces();
            TeamMemberService proxy = (TeamMemberService) Proxy.newProxyInstance(memberClassLoader, interfaces, new TeamServiceInvocationHandler(user));
            proxy.update(member);
        } catch (Exception e) {
            log.info("Exception Message::" + e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id, @Valid TeamMemberDto userDto) {
        try {
            TeamMember member = service.findById(id);
            TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
            ClassLoader memberClassLoader = member.getClass().getClassLoader();
            Class[] interfaces = member.getClass().getInterfaces();
            TeamMemberService proxy = (TeamMemberService) Proxy.newProxyInstance(memberClassLoader, interfaces, new TeamServiceInvocationHandler(user));
            proxy.deleteById(id);
        } catch (Exception e) {
            log.info("Exception Message::" + e.getMessage());
        }
    }
}

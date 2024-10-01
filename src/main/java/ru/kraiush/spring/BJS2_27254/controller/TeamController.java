package ru.kraiush.spring.BJS2_27254.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kraiush.spring.BJS2_27254.dto.TeamMemberDto;
import ru.kraiush.spring.BJS2_27254.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.service.TeamMemberService;
import ru.kraiush.spring.BJS2_27254.service.impl.TeamMemberServiceImpl;
import ru.kraiush.spring.BJS2_27254.service.proxy.TeamServiceInvocationHandler;
import ru.kraiush.spring.BJS2_27254.util.MapperUtil;

import java.lang.reflect.Proxy;
import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class TeamController {

    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    private final TeamMemberServiceImpl service;

    @GetMapping
    public ResponseEntity<List<TeamMemberDto>> findAll() {
        log.info("start load All members");
        List<TeamMember> members = service.findAll();
        return new ResponseEntity<>(MapperUtil.convertList(members, TeamMemberDto.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamMemberDto> createTeamMember(@RequestBody TeamMemberDto memberDto, @RequestBody TeamMemberDto userDto) {
        log.info("start creating member: ", memberDto);
        TeamMember member = MapperUtil.convertClass(memberDto, TeamMember.class);
        TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
        try {
            ClassLoader memberClassLoader = member.getClass().getClassLoader();
            Class[] interfaces = member.getClass().getInterfaces();
            TeamMemberService proxy = (TeamMemberService) Proxy.newProxyInstance(memberClassLoader, interfaces, new TeamServiceInvocationHandler(user));
            TeamMember memberCreated = proxy.create(member);
//            TeamMember memberCreated = service.create(member);
            return new ResponseEntity<>(MapperUtil.convertClass(memberCreated, TeamMemberDto.class), HttpStatus.CREATED);
        } catch (Exception e) {
            log.info("Exception Message::" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeamMemberDto> getTeamMember(@PathVariable("id") long id) {
        log.info("start load member by id: ", id);
        TeamMember member = service.findById(id);
        return new ResponseEntity<>(MapperUtil.convertClass(member, TeamMemberDto.class), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateTeamMember(@RequestBody TeamMemberDto memberDto, @RequestBody TeamMemberDto userDto) {
        log.info("start update member: ", memberDto);
        TeamMember member = MapperUtil.convertClass(memberDto, TeamMember.class);
        TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
        try {
            ClassLoader memberClassLoader = member.getClass().getClassLoader();
            Class[] interfaces = member.getClass().getInterfaces();
            TeamMemberService proxy = (TeamMemberService) Proxy.newProxyInstance(memberClassLoader, interfaces, new TeamServiceInvocationHandler(user));
            proxy.update(member);
//            service.update(member);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info("Exception Message::" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id, @RequestBody TeamMemberDto userDto) {
        try {
            TeamMember member = service.findById(id);
            TeamMember user = MapperUtil.convertClass(userDto, TeamMember.class);
            ClassLoader memberClassLoader = member.getClass().getClassLoader();
            Class[] interfaces = member.getClass().getInterfaces();
            TeamMemberService proxy = (TeamMemberService) Proxy.newProxyInstance(memberClassLoader, interfaces, new TeamServiceInvocationHandler(user));
            proxy.deleteById(id);
//            service.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.info("Exception Message::" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

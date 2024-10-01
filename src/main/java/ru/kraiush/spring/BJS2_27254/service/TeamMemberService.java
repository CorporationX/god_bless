package ru.kraiush.spring.BJS2_27254.service;

import ru.kraiush.spring.BJS2_27254.model.TeamMember;

import java.util.List;

public interface TeamMemberService {

    TeamMember findById(long id);

    List<TeamMember> findAll();

    TeamMember create(TeamMember person) throws Exception;

    void update(TeamMember person) throws Exception;

    void deleteById(long id) throws Exception;

    void deleteAll() throws Exception;
}

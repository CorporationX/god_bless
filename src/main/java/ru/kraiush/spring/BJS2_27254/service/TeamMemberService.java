package ru.kraiush.spring.BJS2_27254.service;

import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;

import java.util.List;
import java.util.Optional;

public interface TeamMemberService {
    Optional<TeamMember> findById(long id);

    List<TeamMember> findAll();

    TeamMember create(TeamMember item);

    TeamMember update(TeamMember item);

    String findRoleById(Long userID);

    void deleteById(long id);

    void deleteAll();
}

package ru.kraiush.spring.BJS2_27254.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import ru.kraiush.spring.BJS2_27254.model.TeamMember;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url= jdbc:postgresql://localhost:5432/werewolf"
})
class TeamMemberRepositoryTest {

    @Autowired
    TeamMemberRepository repository;

    @Test
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldReturnMembers() {
        List<TeamMember> members = repository.findAll();
        assertEquals(4, members.size());
    }

    @Test
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldReturnOneMember() {
        Optional<TeamMember> member = repository.findById(777l);
        assertNotNull(member.get());
    }

    @Test
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void findMemberByName() {
        TeamMember member= repository.findMemberByName("Aphrodite");
        assertNotNull(member);
    }
}
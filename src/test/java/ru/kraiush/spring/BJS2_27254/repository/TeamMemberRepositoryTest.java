package ru.kraiush.spring.BJS2_27254.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext
@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url= jdbc:postgresql://localhost:5432/werewolf"
})
class TeamMemberRepositoryTest {

    @Autowired
    TeamMemberRepository repository;

    @Test
    @Order(1)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldReturnMembers() {
        List<TeamMember> members = repository.findAll();
        assertThat(members.size() >= 4);
    }

    @Test
    @Order(2)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldReturnOneMember() {
        Optional<TeamMember> member = repository.findById(987222l);
        assertNotNull(member.get());
    }

    @Test
    @Order(3)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void findMemberByName() {
        Optional<TeamMember> member = repository.findByName("Nemesis");
        assertNotNull(member.get());
    }

    @Test
    @Order(4)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void createMember() {
        TeamMember member = createTeamMember();
        TeamMember saveMember = repository.save(member);
        Optional<TeamMember> optionalMember = repository.findById(saveMember.getId());
        assertThat(optionalMember.get()).isNotNull();
        assertThat(optionalMember.get().getName().equals("Poseidon"));
    }

    @DisplayName("Should increment the size of list after save")
    @Test
    @Order(5)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldIncrementSizeListAfterSave() {
        int initialSize = repository.findAll().size();
        TeamMember member = createTeamMember();
        TeamMember saveMember = repository.save(member);
        assertEquals(initialSize + 1, repository.findAll().size());
        assertNotEquals(repository.findAll().size(), 0);
    }

    @DisplayName("Should update ann item")
    @Test
    @Order(6)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldUpdateMember() {
        Optional<TeamMember> memberOptional = repository.findById(987777L);
        if (memberOptional.isPresent()) {
            memberOptional.get().setName("Appolon");
            TeamMember member = repository.save(memberOptional.get());
            assertEquals(member.getName(), "Appolon");
        }
    }

    private static TeamMember createTeamMember() {
        return TeamMember.builder()
                .id(3876l)
                .name("Artemis")
                .gender(false)
                .email("artemis@olymp.gc")
                .location("Olympus")
                .age(1797)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_USER)
                .build();
    }
}
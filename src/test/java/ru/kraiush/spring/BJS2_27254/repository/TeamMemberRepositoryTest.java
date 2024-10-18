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
    @DisplayName("JUnit test for get all members operation")
    @Order(1)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMembersList_whenFindAll_thenTeamMembersList() {
        List<TeamMember> memberList = repository.findAll();
        assertThat(memberList).isNotNull();
        assertThat(memberList.size() >= 4);
    }

    @Test
    @DisplayName("JUnit test for get member by id operation")
    @Order(2)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMemberObject_whenFindById_thenReturnTeamMemberObject() {
        Optional<TeamMember> member = repository.findById(987777l);
        assertNotNull(member.get());
    }

    @Test
    @DisplayName("JUnit test for get member by name operation")
    @Order(3)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMemberObject_whenFindByName_thenReturnTeamMemberObject() {
        Optional<TeamMember> member = repository.findByName("Nemesis");
        assertNotNull(member.get());
    }

    @Test
    @DisplayName("JUnit test for get role by id operation")
    @Order(4)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMemberRole_whenFindById_thenReturnTeamMemberRole() {
        String role = repository.findRoleById(987333l);
        assertThat(role.equals("ROLE_OWNER"));
        assertNotNull(role);
    }

    @Test
    @DisplayName("JUnit test for create member operation")
    @Order(5)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void givenTeamMemberObject_whenSave_thenReturnSavedTeamMember() {
        TeamMember member = getTeamMember();
        TeamMember savedMember = repository.save(member);
        Optional<TeamMember> optionalMember = repository.findById(savedMember.getId());
        assertThat(optionalMember.get()).isNotNull();
        assertThat(optionalMember.get().getName().equals("Artemis"));
        assertThat(savedMember).isNotNull();
        assertThat(savedMember.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Should increment the size of list after save")
    @Order(6)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldIncrementSizeList_afterSaveNewTeamMember() {
        int initialSize = repository.findAll().size();
        TeamMember member = getTeamMember();
        repository.save(member);
        assertEquals(initialSize + 1, repository.findAll().size());
        assertNotEquals(repository.findAll().size(), 0);
    }

    @Test
    @DisplayName("JUnit test for update member operation")
    @Order(7)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMemberObject_whenUpdateTeamMember_thenReturnUpdatedTeamMember() {
        Optional<TeamMember> memberOptional = repository.findById(987777L);
        if (memberOptional.isPresent()) {
            memberOptional.get().setName("ApolLo");
            memberOptional.get().setEmail("apollo@olymp.gc");
            TeamMember member = repository.save(memberOptional.get());
            assertEquals(member.getName(), "ApolLo");
            assertEquals(member.getEmail(), "apollo@olymp.gc");
        }
    }

    private static TeamMember getTeamMember() {
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
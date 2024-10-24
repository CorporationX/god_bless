package ru.kraiush.spring.BJS2_27254.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext
@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url= jdbc:postgresql://localhost:5432/werewolf"
})
class TeamMemberRepositorySqlTest {

    @Autowired
    TeamMemberRepository repository;

    @Test
    @DisplayName("JUnit test for get all members operation")
    @Order(1)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMembersList_whenFindAll_thenTeamMembersList() {
        var memberList = repository.findAll();
        assertThat(memberList).isNotNull();
        assertThat(memberList.size() >= 4);
    }

    @Test
    @DisplayName("JUnit test for get member by id operation")
    @Order(2)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMemberObject_whenFindById_thenReturnTeamMemberObject() {
        var member = repository.findById(987777l);
        assertNotNull(member.get());
    }

    @Test
    @DisplayName("JUnit test for get member by name operation")
    @Order(3)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMemberObject_whenFindByName_thenReturnTeamMemberObject() {
        var member = repository.findByName("Hermes");
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
        var member = getTeamMember();
        var savedMember = repository.save(member);
        assertThat(savedMember).isNotNull();
        assertThat(savedMember.getId()).isGreaterThan(0);
        var optionalMember = repository.findById(savedMember.getId());
        assertThat(optionalMember.get().getName().equals("Artemis"));
    }

    @Test
    @DisplayName("Should increment the size of list after save")
    @Order(6)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    void shouldIncrementSizeList_afterSaveNewTeamMember() {
        var initialSize = repository.findAll().size();
        var member = getTeamMember();
        repository.save(member);
        assertEquals(initialSize + 1, repository.findAll().size());
        assertNotEquals(repository.findAll().size(), 0);
    }

    @Test
    @DisplayName("JUnit test for update member operation")
    @Order(7)
    @Sql("/scripts/INIT_MEMBER_PHONE.sql")
    public void givenTeamMemberObject_whenUpdateTeamMember_thenReturnUpdatedTeamMember() {
        var memberOptional = repository.findById(987777L);
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
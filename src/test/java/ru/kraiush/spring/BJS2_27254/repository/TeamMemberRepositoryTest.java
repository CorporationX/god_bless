package ru.kraiush.spring.BJS2_27254.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.DirtiesContext;
import ru.kraiush.spring.BJS2_27254.model.TeamMember;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext
@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url= jdbc:postgresql://localhost:5432/werewolf"
})

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamMemberRepositoryTest {

    @Autowired
    TeamMemberRepository repository;

    @BeforeAll
    static void setup(@Autowired DataSource dataSource) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("scripts/INIT_MEMBER_PHONE.sql"));
        }
    }

    @Test
    @Order(1)
    void shouldReturnMembers() {
        List<TeamMember> members = repository.findAll();
        assertThat(members.size() >= 4);
    }

    @Test
    @Order(2)
    void shouldReturnOneMember() {
        Optional<TeamMember> member = repository.findById(987222l);
        assertNotNull(member.get());
    }

    @Test
    @Order(3)
    void findMemberByName() {
        TeamMember member = repository.findMemberByName("Athena");
        assertNotNull(member);
    }

    @Test
    @Order(4)
    void createMember() {
        TeamMember member = createTeamMember();
        TeamMember saveMember = repository.save(member);
        Optional<TeamMember> optionalMember = repository.findById(saveMember.getId());
        assertThat(optionalMember.get()).isNotNull();
        assertThat(optionalMember.get().getName().equals("Artemis"));
    }

    @DisplayName("Should increment the size of list after save")
    @Test
    @Order(5)
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
    void shouldUpdateMember() {
        Optional<TeamMember> memberOptional = repository.findById(987777L);
        if (memberOptional.isPresent()) {
            memberOptional.get().setName("Hermes");
            TeamMember member = repository.save(memberOptional.get());
            assertEquals(member.getName(), "Hermes");
        }
    }

    private static TeamMember createTeamMember() {
        return new TeamMember(3876l, "Artemis", true, "nika@olymp.gc", "Olympus", 17, LocalDateTime.now(), "ROLE_USER");
    }
}
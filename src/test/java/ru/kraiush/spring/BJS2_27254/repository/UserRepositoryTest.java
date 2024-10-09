package ru.kraiush.spring.BJS2_27254.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.DirtiesContext;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
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
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @BeforeAll
    static void setup(@Autowired DataSource dataSource) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("scripts/INIT_MEMBER_PHONE.sql"));
        }
    }

    @Test
    @Order(1)
    void shouldReturnMembers() {
        List<User> members = repository.findAll();
        assertThat(members.size() >= 4);
    }

    @Test
    @Order(2)
    void shouldReturnOneMember() {
        Optional<User> member = repository.findById(987222l);
        assertNotNull(member.get());
    }

    @Test
    @Order(3)
    void findMemberByName() {
        Optional<User> member = repository.findByUsername("Athena");
        assertNotNull(member.get());
    }

    @Test
    @Order(4)
    void createMember() {
        User member = createUser();
        User saveMember = repository.save(member);
        Optional<User> optionalMember = repository.findById(saveMember.getId());
        assertThat(optionalMember.get()).isNotNull();
        assertThat(optionalMember.get().getUsername().equals("Artemis"));
    }

    @DisplayName("Should increment the size of list after save")
    @Test
    @Order(5)
    void shouldIncrementSizeListAfterSave() {
        int initialSize = repository.findAll().size();
        User member = createUser();
        User saveMember = repository.save(member);
        assertEquals(initialSize + 1, repository.findAll().size());
        assertNotEquals(repository.findAll().size(), 0);
    }

    @DisplayName("Should update ann item")
    @Test
    @Order(6)
    void shouldUpdateMember() {
        Optional<User> memberOptional = repository.findById(987777L);
        if (memberOptional.isPresent()) {
            memberOptional.get().setUsername("Hermes");
            User member = repository.save(memberOptional.get());
            assertEquals(member.getUsername(), "Hermes");
        }
    }

    private static User createUser() {
        return new User(3876l, "Artemis", true, "nika@olymp.gc", "Olympus", 17, LocalDateTime.now(), Role.ROLE_USER, "password");
    }

}
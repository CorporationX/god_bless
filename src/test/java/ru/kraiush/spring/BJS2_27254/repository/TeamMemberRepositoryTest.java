package ru.kraiush.spring.BJS2_27254.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import ru.kraiush.spring.BJS2_27254.domain.model.Phone;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext
@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url= jdbc:postgresql://localhost:5432/werewolf"
})
public class TeamMemberRepositoryTest {

    @Autowired
    private TeamMemberRepository repository;

    @Autowired
    TestEntityManager em;

    private TeamMember member1;
    private TeamMember member2;
    private TeamMember member3;
    private TeamMember member4;

    @BeforeEach
    public void setup() {
        member1 = createTeamMemberOne();
        member2 = createTeamMemberTwo();
        member3 = createTeamMemberThree();
        member4 = createTeamMemberFourth();
    }

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(em);
    }

    @Test
    @DisplayName("JUnit test for save member operation")
    @Order(1)
    void givenNewMember_whenSave_thenSuccess() {
        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(new Phone(new Random().nextLong(1, 100), new Random().nextInt(11)));
        listPhones.add(new Phone(new Random().nextLong(101, 200), new Random().nextInt(11)));
        member4.setPhones(listPhones);
        var savedMember = repository.save(member4);

        assertThat(savedMember).isNotNull();
        assertThat(savedMember.getId()).isGreaterThan(0);
        Optional<TeamMember> optionalMember = repository.findById(savedMember.getId());
        assertThat(optionalMember.get()).isNotNull();
        assertEquals(optionalMember.get().getName(), "Athena");
        assertThat(member4).hasFieldOrPropertyWithValue("gender", false);
        assertThat(member4).hasFieldOrPropertyWithValue("email", "athena@greece.com");
        assertThat(member4).hasFieldOrPropertyWithValue("location", "Athens");
        assertThat(member4).hasFieldOrPropertyWithValue("role", Role.ROLE_FAKE);
    }

    @Test
    @DisplayName("JUnit test for get all members operation")
    @Order(2)
    public void givenTeamMembersList_whenFindAll_thenTeamMembersList() {
        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(new Phone(new Random().nextLong(1, 100), new Random().nextInt(11)));
        listPhones.add(new Phone(new Random().nextLong(100, 200), new Random().nextInt(11)));
        member1.setPhones(listPhones);
        repository.save(member1);
        repository.save(member2);

        var memberList = repository.findAll();
        assertThat(memberList).isNotNull();
        assertThat(memberList.size() >= 4);
        assertThat(memberList.contains(member1));
        assertThat(memberList.contains(member2));
    }

    @Test
    @DisplayName("JUnit test for get member by id operation")
    @Order(3)
    public void givenTeamMemberObject_whenFindById_thenReturnTeamMemberObject() {
        repository.save(member1);
        var memberOptional = repository.findById(987777l);
        assertThat(memberOptional.isPresent());
    }

    @Test
    @DisplayName("JUnit test for get member by name operation")
    @Order(4)
    public void givenTeamMemberObject_whenFindByName_thenReturnTeamMemberObject() {
        repository.save(member2);
        var memberOptional = repository.findByName("Dayana");
        assertEquals(memberOptional.get().getName(), "Dayana");
    }

    @Test
    @DisplayName("JUnit test for get role by id operation")
    @Order(5)
    public void givenTeamMemberRole_whenFindById_thenReturnTeamMemberRole() {
        var savedMember = repository.save(member3);
        String role = repository.findRoleById(savedMember.getId());
        assertThat(role.equals("ROLE_OWNER"));
        assertThat(savedMember).hasFieldOrPropertyWithValue("role", Role.ROLE_OWNER);
    }

    @Test
    @DisplayName("JUnit test should increment the size of list after save")
    @Order(6)
    void shouldIncrementSizeList_afterSaveNewTeamMember() {
        var initialSize = repository.findAll().size();
        repository.save(member4);
        assertEquals(initialSize + 1, repository.findAll().size());
        assertNotEquals(repository.findAll().size(), 0);
    }

    @Test
    @DisplayName("JUnit test should delete by id")
    @Order(7)
    void shouldDeleteTeamMember_ById() {
        repository.deleteById(member3.getId());
        Optional<TeamMember> test = repository.findById(member3.getId());
        assertTrue(test.isEmpty());
    }

    @Test
    @DisplayName("JUnit test for update member operation")
    @Order(8)
    public void givenTeamMemberObject_whenUpdateTeamMember_thenReturnUpdatedTeamMember() {
        repository.save(member1);
        var memberOptional = repository.findById(987777L);
        if (memberOptional.isPresent()) {
            memberOptional.get().setName("Aphrodite");
            memberOptional.get().setEmail("aphrodite@olymp.gc");
            memberOptional.get().setGender(false);
            repository.save(memberOptional.get());
            assertEquals(memberOptional.get().getName(), "Aphrodite");
            assertEquals(memberOptional.get().getEmail(), "aphrodite@olymp.gc");
            assertFalse(memberOptional.get().isGender());
        }
    }

    private static TeamMember createTeamMemberOne() {
        return TeamMember.builder()
                .id(987777l)
                .name("Artemis")
                .gender(true)
                .email("artemis@olymp.gc")
                .location("Olympus")
                .age(1797)
                .lastDate(LocalDateTime.of(2024, 1, 1, 1, 0, 0, 0))
                .role(Role.ROLE_TEAMLEAD)
                .build();
    }

    private static TeamMember createTeamMemberTwo() {
        return TeamMember.builder()
                .id(new Random().nextLong(1, 100000))
                .name("Dayana")
                .gender(false)
                .email("dayana@olymp.gc")
                .location("Crete")
                .age(19)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_FAKE)
                .build();
    }

    private static TeamMember createTeamMemberThree() {
        return TeamMember.builder()
                .id(987333l)
                .name("Poseidon")
                .gender(true)
                .email("poseidon@greece.com")
                .location("Sparta")
                .age(1999)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_OWNER)
                .build();
    }

    private static TeamMember createTeamMemberFourth() {
        return TeamMember.builder()
                .id(new Random().nextLong(1, 100000))
                .name("Athena")
                .gender(false)
                .email("athena@greece.com")
                .location("Athens")
                .age(17)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_FAKE)
                .build();
    }
}
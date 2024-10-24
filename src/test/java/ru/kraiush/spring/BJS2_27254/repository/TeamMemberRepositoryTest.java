package ru.kraiush.spring.BJS2_27254.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

    @Test
    @DisplayName("JUnit test for save member operation")
    @Order(1)
    void givenNewMember_whenSave_thenSuccess() {
        var member = createTeamMemberFourth();
        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(new Phone(new Random().nextLong(1, 100), new Random().nextInt(11)));
        listPhones.add(new Phone(new Random().nextLong(101, 200), new Random().nextInt(11)));
        member.setPhones(listPhones);
        var savedMember = repository.save(member);

        assertThat(savedMember).isNotNull();
        assertThat(savedMember.getId()).isGreaterThan(0);
        Optional<TeamMember> optionalMember = repository.findById(savedMember.getId());
        assertThat(optionalMember.get()).isNotNull();
        assertThat(optionalMember.get().getName().equals("Athena"));
        assertThat(member).hasFieldOrPropertyWithValue("gender", false);
        assertThat(member).hasFieldOrPropertyWithValue("email", "athena@greece.com");
        assertThat(member).hasFieldOrPropertyWithValue("location", "Athens");
        assertThat(member).hasFieldOrPropertyWithValue("role", Role.ROLE_FAKE);
    }

    @Test
    @DisplayName("JUnit test for get all members operation")
    @Order(2)
    public void givenTeamMembersList_whenFindAll_thenTeamMembersList() {
        var member1 = createTeamMemberOne();
        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(new Phone(new Random().nextLong(1, 100), new Random().nextInt(11)));
        listPhones.add(new Phone(new Random().nextLong(100, 200), new Random().nextInt(11)));
        member1.setPhones(listPhones);
        var member2 = createTeamMemberTwo();
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
        var member = createTeamMemberOne();
        repository.save(member);
        var memberOptional = repository.findById(987777l);
        assertThat(memberOptional.isPresent());
    }

    @Test
    @DisplayName("JUnit test for get member by name operation")
    @Order(4)
    public void givenTeamMemberObject_whenFindByName_thenReturnTeamMemberObject() {
        var member = createTeamMemberTwo();
        repository.save(member);
        var memberOptional = repository.findByName("Dayana");
        assertThat(memberOptional.get().getName().equals("Dayana"));
    }

    @Test
    @DisplayName("JUnit test for get role by id operation")
    @Order(6)
    public void givenTeamMemberRole_whenFindById_thenReturnTeamMemberRole() {
        var member = createTeamMemberThree();
        var savedMember = repository.save(member);
        String role = repository.findRoleById(savedMember.getId());
        assertThat(role.equals("ROLE_OWNER"));
        assertThat(savedMember).hasFieldOrPropertyWithValue("role", Role.ROLE_OWNER);
    }

    @Test
    @DisplayName("JUnit test should increment the size of list after save")
    @Order(7)
    void shouldIncrementSizeList_afterSaveNewTeamMember() {
        var initialSize = repository.findAll().size();
        var member = createTeamMemberFourth();
        repository.save(member);
        assertEquals(initialSize + 1, repository.findAll().size());
        assertNotEquals(repository.findAll().size(), 0);
    }

    @Test
    @DisplayName("JUnit test should delete by id")
    @Order(8)
    void shouldDeleteTeamMember_ById() {
        var member = createTeamMemberThree();
        repository.deleteById(member.getId());
        Optional<TeamMember> test = repository.findById(member.getId());
        assertTrue(test.isEmpty());
    }

    @Test
    @DisplayName("JUnit test for update member operation")
    @Order(9)
    public void givenTeamMemberObject_whenUpdateTeamMember_thenReturnUpdatedTeamMember() {
        var member = createTeamMemberOne();
        repository.save(member);
        var memberOptional = repository.findById(987777L);
        if (memberOptional.isPresent()) {
            memberOptional.get().setName("Aphrodite");
            memberOptional.get().setEmail("aphrodite@olymp.gc");
            memberOptional.get().setGender(false);
            repository.save(memberOptional.get());
            assertEquals(memberOptional.get().getName(), "Aphrodite");
            assertEquals(memberOptional.get().getEmail(), "aphrodite@olymp.gc");
            assertEquals(memberOptional.get().isGender(), false);
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
package ru.kraiush.spring.BJS2_27254.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("Must be created correctly")
    @Test
    void checkConstructUser() {
        User member = createUser();
        assertAll(
                () -> assertThat(member.getRole()).isEqualTo(Role.ROLE_USER),
                () -> assertNotEquals("Lolita", member.getUsername()),
                () -> assertThat(member.getUsername()).isEqualTo("Flora"),
                () -> assertTrue(!member.getUsername().isEmpty() || !member.getUsername().isBlank()),
                () -> assertEquals(member.getAge(), 17),
                () -> assertThat(member.getId()).isEqualTo(3876l),
                () -> assertThat(member).hasFieldOrPropertyWithValue("id", 3876l)
        );
    }

    private static User createUser() {
        return new User(3876l, "Flora", true, "flora@olymp.gc", "Olympus", 17, LocalDateTime.now(), Role.ROLE_USER, "pass");
    }

}
package ru.kraiush.spring.BJS2_27254.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TeamMemberTest {
    @DisplayName("Must be created correctly")
    @Test
    void checkConstructTeamMember() {
        TeamMember member = createTeamMember();
        assertAll(
                () -> assertThat(member.getRole()).isEqualTo(Role.ROLE_USER),
                () -> assertNotEquals("Lolita", member.getName()),
                () -> assertThat(member.getName()).isEqualTo("Flora"),
                () -> assertTrue(!member.getName().isEmpty() || !member.getName().isBlank()),
                () -> assertEquals(member.getAge(), 17),
                () -> assertThat(member.getId()).isEqualTo(3876l),
                () -> assertThat(member).hasFieldOrPropertyWithValue("id", 3876l)
        );
    }
    private static TeamMember createTeamMember() {
        return TeamMember.builder()
                .id(3876l)
                .name("Flora")
                .gender(false)
                .email("flora@olymp.gc")
                .location("Olympus")
                .age(17)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_USER)
                .build();
    }
}
package faang.school.godbless.groupUsers.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void findHobbyLovers_shouldReturnEmptyMap() {
        var result = User.findHobbyLovers(List.of(
                User.builder().hobbies(Set.of("reading")).build(),
                User.builder().hobbies(Set.of("dancing")).build()
        ), Set.of("running"));
        assertTrue(result.isEmpty());
    }

    @Test
    public void findHobbyLovers_shouldReturnMatches() {
        var result = User.findHobbyLovers(List.of(
                User.builder().hobbies(Set.of("swimming", "games")).build(),
                User.builder().hobbies(Set.of("eating", "reading")).build(),
                User.builder().hobbies(Set.of("reading", "cooking")).build()
        ), Set.of("cooking", "swimming"));
        assertEquals(2, result.size());
    }
}

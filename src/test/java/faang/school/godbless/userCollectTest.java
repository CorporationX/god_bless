package faang.school.godbless;

import Collect.UserCollect;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class userCollectTest {
    @Test
    void findHobbyLovers_shouldReturnEmptyMapWithEmptyListAndEmptySet() {
        var resultWithEmptyList = UserCollect.findHobbyLovers(Collections.emptyList(), Set.of("swimming", "coding"));
        var resultWithEmptySet = UserCollect.findHobbyLovers(List.of(new UserCollect()), Collections.emptySet());

        assertAll(() -> {
            assertTrue(resultWithEmptyList.isEmpty());
            assertTrue(resultWithEmptySet.isEmpty());
        });
    }

    @Test
    void findHobbyLovers_shouldReturnEmptyMap() {
        var result = UserCollect.findHobbyLovers(List.of(
                UserCollect.builder().hobbies(Set.of("swimming")).build(),
                UserCollect.builder().hobbies(Set.of("coding")).build()
        ), Set.of("dancing"));

        assertTrue(result.isEmpty());
    }

    @Test
    void findHobbyLovers_shouldReturnMatches() {
        UserCollect player = UserCollect.builder().hobbies(Set.of("swimming", "playing")).build();
        UserCollect programmer = UserCollect.builder().hobbies(Set.of("coding")).build();
        UserCollect boxer = UserCollect.builder().hobbies(Set.of("dancing", "boxing")).build();
        var result = UserCollect.findHobbyLovers(List.of(player, programmer, boxer), Set.of("boxing", "playing"));

        assertEquals(2, result.size());
        assertEquals("boxing", result.get(boxer));
    }
}

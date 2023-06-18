package faang.school.godbless.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserWithHobbyTest {

    private static final long ID = 1L;
    private static final String NAME = "NAME";
    private static final byte AGE = 17;
    private static final Set<String> HOBBIES = new LinkedHashSet<>(Set.of("Music", "Coding", "Photo", "Travel", "Sport", "Reading"));
    private static final Set<String> MATCHED_HOBBIES = new LinkedHashSet<>(Set.of("Music", "Travel", "Codding"));
    private static final Set<String> UNMATCHED_HOBBIES = new LinkedHashSet<>(Set.of("Cooking", "Dancing", "Carting"));


    @Test
    void whenUsersWithHobbyThenReturnMap() {
        UserWithHobby user1 = UserWithHobby.builder().id(ID).name(NAME).age(AGE).hobbies(MATCHED_HOBBIES).build();
        UserWithHobby user2 = UserWithHobby.builder().id(ID).name(NAME).age(AGE).hobbies(UNMATCHED_HOBBIES).build();
        UserWithHobby user3 = UserWithHobby.builder().id(ID).name(NAME).age(AGE).hobbies(Collections.emptySet()).build();

        List<UserWithHobby> users = List.of(user1, user2, user3);

        Map<UserWithHobby, String> actual = UserWithHobby.findHobbyLovers(users, HOBBIES);

        assertEquals(1, actual.size());

        assertTrue(actual.containsKey(user1));
        assertFalse(actual.containsKey(user2));
        assertFalse(actual.containsKey(user3));
    }

    @Test
    void whenUsersWithoutHobbyThenReturnEmptyMap() {
        Map<UserWithHobby, String> users = UserWithHobby.findHobbyLovers(
            List.of(UserWithHobby.builder().id(ID).name(NAME).age(AGE).hobbies(MATCHED_HOBBIES).build()),
            Collections.emptySet()
        );
        assertTrue(users.isEmpty());
    }

    @Test
    void whenEmptyUserListThenReturnEmptyMap() {
        Map<UserWithHobby, String> users = UserWithHobby.findHobbyLovers(
            Collections.emptyList(),
            MATCHED_HOBBIES
        );
        assertTrue(users.isEmpty());
    }

    @Test
    void whenEmptyUserListAndEmptyHobbiesThenReturnEmptyMap() {
        Map<UserWithHobby, String> users = UserWithHobby.findHobbyLovers(
            Collections.emptyList(),
            Collections.emptySet()
        );
        assertTrue(users.isEmpty());
    }
}

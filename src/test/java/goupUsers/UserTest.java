package goupUsers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void groupUsers_shouldReturnEmptyMapWithNullList() {
        var result = User.groupUsers(null);

        assertTrue(result.isEmpty());
    }
    @Test
    @DisplayName("Ждем пустую мапу от пустого листа")
    void groupUsers_shouldReturnEmptyMapWithEmptyList() {
        var result = User.groupUsers(Collections.emptyList());

        assertEquals(0, result.size());
    }

    @Test
    void groupUsers_shouldReturnCorrectMap() {
        List<User> users = List.of(
                new User("Ivan", 22, "Yandex", "Moscow"),
                new User("Alex", 20, "Uber", "London"),
                new User("Jane", 22, "Yandex", "Moscow")
        );

        var result = User.groupUsers(users);

        assertEquals(2, result.size());
        assertTrue(result.containsKey(22));
        assertEquals(2, result.get(22).size());
    }

}
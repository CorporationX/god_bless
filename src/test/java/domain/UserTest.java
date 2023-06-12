package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("Sasha", 23, "Dark Project", "Berlin"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("Mark", 19, "Amazon", "Chili"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("Arman", 16, "Google", "New York"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User(null, 23, "Google", "Moscow"));
    }

    @Test
    public void shouldNotThrowException() {
        Assertions.assertDoesNotThrow(() ->
                new User("Sasha", 23, "Google", "New York"));
        Assertions.assertDoesNotThrow(() ->
                new User("Mark", 19, "Amazon", "Amsterdam"));
        Assertions.assertDoesNotThrow(() ->
                new User("Arman", 19, "Google", "New York"));
        Assertions.assertDoesNotThrow(() ->
                new User("Oleg", 23, "Google", "London"));
    }

}

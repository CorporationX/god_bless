import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import school.faang.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(UUID.randomUUID(), "", 10, new HashSet<>());
    }

    @Test
    public void checkWhenEmptyHobbies() {
        // Arrange
        var testData = new ArrayList<User>();

        var user = new User(
                UUID.randomUUID(),
                "Alex",
                10,
                new HashSet<>(Arrays.asList("Hockey", "Swimming", "Football")));
        testData.add(user);

        user = new User(
                UUID.randomUUID(),
                "Ivan",
                10,
                new HashSet<>(Arrays.asList("Swimming", "Football")));
        testData.add(user);

        user = new User(
                UUID.randomUUID(),
                "Pavel",
                10,
                new HashSet<>(Arrays.asList("Diving", "Skating")));
        testData.add(user);

        user = new User(
                UUID.randomUUID(),
                "Alexey",
                10,
                new HashSet<>(List.of()));
        testData.add(user);

        user = new User(
                UUID.randomUUID(),
                "Masha",
                10,
                new HashSet<>(Arrays.asList("Hockey", "Swimming", "Football", "Diving", "Skating")));
        testData.add(user);

        var hobbiesToFind = new HashSet<String>();

        // Act
        var result = User.findHobbyLovers(testData, hobbiesToFind);

        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void checkWhenEmptyUsersList() {
        var testData = new ArrayList<User>();
        var hobbiesToFind = new HashSet<>(Arrays.asList("Hockey", "Swimming", "Skiing"));

        var result = User.findHobbyLovers(testData, hobbiesToFind);

        Assertions.assertTrue(result.isEmpty());
    }
}

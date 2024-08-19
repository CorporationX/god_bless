package faang.school.godbless;

import faang.school.godbless.dolbahlop.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private List<User> users;

    @BeforeEach
    void setUp() {
        // Data Arrange
        users = new ArrayList<>();
        users.add(new User("Alice", 25, "Company A", "Address 1"));
        users.add(new User("Bob", 30, "Company B", "Address 2"));
        users.add(new User("Charlie", 25, "Company C", "Address 3"));
        users.add(new User("David", 30, "Company D", "Address 4"));
        users.add(new User("Eve", 35, "Company E", "Address 5"));
    }

    @ParameterizedTest
    @CsvSource({
            "25, 2",
            "30, 2",
            "35, 1",
    })
    void shouldGroupUsersByAgeCorrectly(int age, int expectedCount) {
        // Arrange
        Map<Integer, List<User>> groupedByAge = User.groupUsersByAge(users);

        // Act
        List<User> usersWithinAgeGroup = groupedByAge.get(age);

        // Assert
        assertEquals(expectedCount, usersWithinAgeGroup.size(), "Должно быть " + expectedCount + " пользователей в возрастной группе " + age);
    }
}


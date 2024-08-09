package faang.school.godbless.group_users_by_age;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // Negative
    @Test
    public void testGroupUsersEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(List.of()));
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(null));
    }

    // Positive
    @Test
    public void testGroupUsers() {
        List<User> users = List.of(
                new User("Alice Smith", 28, "Google", "1234 Maple St"),
                new User("Ivy Moore", 28, "Uber", "2223 Ash St"),
                new User("Emma Jones", 35, "Microsoft", "1415 Birch St"),
                new User("Bob Johnson", 35, "Amazon", "5678 Oak St"),
                new User("Grace Davis", 32, "Tesla", "1819 Spruce St"),
                new User("Carol Williams", 32, "Facebook", "9101 Pine St"),
                new User("David Brown", 40, "Apple", "1213 Elm St"),
                new User("Frank Miller", 40, "Netflix", "1617 Cedar St"),
                new User("Henry Wilson", 47, "SpaceX", "2021 Fir St"),
                new User("Jack Taylor", 47, "Airbnb", "2425 Cherry St")
        );

        Map<Integer, List<User>> ageUsersMap = User.groupUsers(users);
        assertEquals(5, ageUsersMap.entrySet().size());
        assertEquals(2, ageUsersMap.get(40).size());
        assertEquals(2, ageUsersMap.get(32).size());

        assertEquals("Henry Wilson", ageUsersMap.get(47).get(0).getName());
        assertEquals("Jack Taylor", ageUsersMap.get(47).get(1).getName());
    }

    // Boundary
    @Test
    public void testGroupUsersSameAge() {
        List<User> users = List.of(
                new User("Alice Smith", 28, "Google", "1234 Maple St"),
                new User("Bob Johnson", 28, "Amazon", "5678 Oak St"),
                new User("Carol Williams", 28, "Facebook", "9101 Pine St"),
                new User("David Brown", 28, "Apple", "1213 Elm St"),
                new User("Emma Jones", 28, "Microsoft", "1415 Birch St"),
                new User("Frank Miller", 28, "Netflix", "1617 Cedar St"),
                new User("Grace Davis", 28, "Tesla", "1819 Spruce St"),
                new User("Henry Wilson", 28, "SpaceX", "2021 Fir St"),
                new User("Ivy Moore", 28, "Uber", "2223 Ash St"),
                new User("Jack Taylor", 28, "Airbnb", "2425 Cherry St")
        );

        Map<Integer, List<User>> ageUsersMap = User.groupUsers(users);
        assertEquals(1, ageUsersMap.entrySet().size());
        assertEquals(10, ageUsersMap.get(28).size());
    }
}

package school.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class UserTest {

    @Test
    public void shouldCreateUser() {
        User user = new User("User1", 33, "Google", "London");
        Assertions.assertAll(
                () -> Assertions.assertEquals("User1", user.getName()),
                () -> Assertions.assertEquals(33, user.getAge()),
                () -> Assertions.assertEquals("Google", user.getCompany()),
                () -> Assertions.assertEquals("London", user.getAddress())
        );
    }

    @Test
    public void shouldGroupUsersByAge() {
        Map<Integer, List<User>> groupedUsers = User.groupUsers(createUsers());

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, groupedUsers.get(25).size()),
                () -> Assertions.assertEquals(1, groupedUsers.get(30).size())
        );
    }

    @Test
    public void shouldThrowExceptionWhenEmptyName() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", 18, "Google", "London"));
        Assertions.assertEquals("Invalid name.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenAgeIncorrect() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Name", 2, "Google", "London"));
        Assertions.assertEquals("Invalid age.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenCompanyIncorrect() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Name", 18, "IncorrectCompany", "London"));
        Assertions.assertEquals("Invalid company.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenAddressIncorrect() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Name", 18, "Google", "IncorrectAddress"));
        Assertions.assertEquals("Invalid address.", exception.getMessage());
    }

    private List<User> createUsers() {
        return List.of(
                new User("User1", 25, "Google", "London"),
                new User("User2", 25, "Amazon", "New York"),
                new User("User3", 30, "Uber", "Amsterdam")
        );
    }
}

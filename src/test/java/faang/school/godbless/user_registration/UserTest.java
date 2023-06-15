package faang.school.godbless.user_registration;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testGroupUsers() {
        User userOne = new User("NameOne", 21, "Google", "Amsterdam");
        User userTwo = new User("NameTwo", 22, "Uber", "New York");
        User userThree = new User("NameThree", 23, "Google", "Amsterdam");
        User userFour = new User("NameFour", 24, "Uber", "New York");
        User userFive = new User("NameFive", 25, "Amazon", "Amsterdam");
        List<User> users = Arrays.asList(userOne, userTwo, userThree, userFour, userFive);

        Map<Integer, List<User>> usersForCheck = User.groupUsers(users);

        assertEquals(5, usersForCheck.size());
        assertTrue(usersForCheck.containsKey(23));
        assertTrue(usersForCheck.containsKey(22));
    }

    @Test
    void testConstructorWithWrongName() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("  ", 21, "Uber", "London"));
    }

    @Test
    void testConstructorWithWrongAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("NameOne", 20, "Uber", "Wrong address"));
    }

    @Test
    void testConstructorWithWrongAge() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("NameOne", 17, "Uber", "London"));

    }

    @Test
    void testConstructorWithWrongPlaceOfWork() {
        assertThrows(IllegalArgumentException.class, () ->
                new User("NameOne", 25, "Wrong place of work", "London"));
    }
}
package faang.school.godbless.user_registration_BC_402;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void testExceptionIsThrown() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", 23, "Amazon", "London"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("name1", 13, "Amazon", "London"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("name2", 33, "Amazon", "Arzamas"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("name3", 43, "Yandex", "London"));
    }

    @Test
    public void testGetList() {
        List<User> testUsers = new ArrayList<>();
        testUsers.add(new User("user1", 23, "Amazon", "Amsterdam"));
        testUsers.add(new User("user2", 23, "Google", "London"));
        testUsers.add(new User("user3", 21, "Amazon", "New York"));
        testUsers.add(new User("user4", 26, "Amazon", "London"));
        testUsers.add(new User("user5", 26, "Uber", "New York"));
        testUsers.add(new User("user6", 33, "Amazon", "London"));
        testUsers.add(new User("user7", 45, "Amazon", "New York"));
        testUsers.add(new User("user8", 45, "Uber", "London"));
        testUsers.add(new User("user9", 45, "Amazon", "Amsterdam"));

        List<User> expectedFirst = new ArrayList<>();
        expectedFirst.add(new User("user1", 23, "Amazon", "Amsterdam"));
        expectedFirst.add(new User("user2", 23, "Google", "London"));
        List<User> expectedSecond = new ArrayList<>();
        expectedSecond.add(new User("user4", 26, "Amazon", "London"));
        expectedSecond.add(new User("user5", 26, "Uber", "New York"));
        List<User> expectedThird = new ArrayList<>();
        expectedThird.add(new User("user6", 33, "Amazon", "London"));
        List<User> expectedFourth = new ArrayList<>();
        expectedFourth.add(new User("user7", 45, "Amazon", "New York"));
        expectedFourth.add(new User("user8", 45, "Uber", "London"));
        expectedFourth.add(new User("user9", 45, "Amazon", "Amsterdam"));

        Assertions.assertEquals(expectedFirst, User.groupUsersByAge(testUsers).get(23));
        Assertions.assertEquals(expectedSecond, User.groupUsersByAge(testUsers).get(26));
        Assertions.assertEquals(expectedThird, User.groupUsersByAge(testUsers).get(33));
        Assertions.assertEquals(expectedFourth, User.groupUsersByAge(testUsers).get(45));
    }
}

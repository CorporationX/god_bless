package faang.school.godbless.user_registation;

import faang.school.godbless.user_registration.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUser {
    @Test
    void groupUsers() {
        User testUser1 = new User("TestName1", 20, "TestCompany1", "TestAddress1");
        User testUser2 = new User("TestName2", 21, "TestCompany2", "TestAddress2");
        User testUser3 = new User("TestName3", 25, "TestCompany2", "TestAddress2");
        User testUser4 = new User("TestName4", 20, "TestCompany1", "TestAddress5");
        User testUser5 = new User("TestName5", 25, "TestCompany2", "TestAddress5");

        List<User> testUserList = Arrays.asList(testUser1, testUser2, testUser3, testUser4, testUser5);

        Map<Integer, List<User>> testUsersMap = User.groupUsers(testUserList);

        assertEquals(3, testUsersMap.size());
        assertTrue(testUsersMap.containsKey(20));
        assertTrue(testUsersMap.containsKey(21));
        assertTrue(testUsersMap.containsKey(25));
    }
}
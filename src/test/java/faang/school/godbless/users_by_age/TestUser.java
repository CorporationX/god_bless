package faang.school.godbless.users_by_age;

import faang.school.godbless.task.ageGroup.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestUser {
    @Test
    void testGroupUsers() {
        User userOne = new User("NameOne", 21, "CompanyOne", "Main street");
        User userTwo = new User("NameTwo", 22, "CompanyTwo", "Main street");
        User userThree = new User("NameThree", 23, "CompanyThree", "Main street");
        User userFour = new User("NameFour", 24, "CompanyFour", "Main street");
        User userFive = new User("NameFive", 25, "CompanyFive", "Main street");
        List<User> users = Arrays.asList(userOne, userTwo, userThree, userFour, userFive);

        Map<Integer, List<User>> usersForCheck = User.groupUsers(users);

        assertEquals(5, usersForCheck.size());
        assertTrue(usersForCheck.containsKey(23));
        assertTrue(usersForCheck.containsKey(22));
    }
}
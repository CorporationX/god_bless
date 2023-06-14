package faang.school.godbless.users_by_age;

import faang.school.godbless.age_group.User;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUser {

    @Test
    void testGroupUsersOne() {
        User userOne = new User("Anna", 21, "Yandex", "Polevaya street");
        User userTwo = new User("Ivan", 22, "Google", "Lenina street");
        User userThree = new User("Maria", 23, "Sber", "Poletaeva street");
        User userFour = new User("Diana", 24, "Yahoo", "Gagarina street");
        User userFive = new User("Vladimir", 25, "X5", "Pochtovaya street");
        List<User> usersOne = Arrays.asList(userOne, userTwo, userThree, userFour, userFive);
        Map<Integer, List<User>> usersForCheck = User.groupUsers(usersOne);
        assertEquals(5, usersForCheck.size());
    }

    @Test
    void testGroupUsersTwo() {
        User userOne = new User("Anna", 27, "Yandex", "Polevaya street");
        User userTwo = new User("Ivan", 22, "Google", "Lenina street");
        User userThree = new User("Maria", 22, "Sber", "Poletaeva street");
        User userFour = new User("Diana", 24, "Yahoo", "Gagarina street");
        User userFive = new User("Vladimir", 27, "X5", "Pochtovaya street");
        List<User> usersOne = Arrays.asList(userOne, userTwo, userThree, userFour, userFive);
        Map<Integer, List<User>> usersForCheck = User.groupUsers(usersOne);
        assertEquals(3, usersForCheck.size());
    }
}
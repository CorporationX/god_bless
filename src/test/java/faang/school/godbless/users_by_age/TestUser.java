package faang.school.godbless.users_by_age;

import faang.school.godbless.age_group.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUser {

    private static User userOne;
    private static User userTwo;
    private static User userThree;
    private static User userFour;
    private static User userFive;
    private static List<User> users;
    private static Map<Integer, List<User>> usersForCheck;

    @BeforeEach
    public void setUp(){
        userOne = new User("Anna", 22, "Yandex", "Polevaya street");
        userTwo = new User("Ivan", 22, "Google", "Lenina street");
        userThree = new User("Maria", 23, "Sber", "Poletaeva street");
        userFour = new User("Diana", 24, "Yahoo", "Gagarina street");
        userFive = new User("Vladimir", 25, "X5", "Pochtovaya street");
        users = Arrays.asList(userOne, userTwo, userThree, userFour, userFive);
    }

    @Test
    public void testGroupUsers() {
        usersForCheck = User.groupUsers(users);
        assertEquals(4, usersForCheck.size());
    }
}
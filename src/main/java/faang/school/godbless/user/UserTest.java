package faang.school.godbless.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;
    private final static String firstName = "First name";
    private final static int age = 20;
    private final static String job = "Google";
    private final static String address = "Spain, Madrid";


    @BeforeEach
    public void setUp() {
        user = new User(firstName, age, job, address);
    }

    @Test
    public void testUserConstructor() {
        assertEquals(user.name, firstName);
        assertEquals(user.age, age);
        assertEquals(user.job, job);
        assertEquals(user.address, address);
    }

    @Test
    public void testGroupUsers() {
        User dima = new User("Dima", 21, "Apple", "France");
        User max = new User("Max", 20, "Uber", "Poland");
        User alex = new User("Alex", 21, "Netflix", "Usa");
        User petr = new User("Petr", 20, "Amazon", "Germany");
        User bryan = new User("Bryan", 19, "Netflix", "Usa");

        List<User> users = List.of(dima, max, alex, petr, bryan);

        Map<Integer, List<User>> expectedUserAgeToUsersResult = new HashMap<Integer, List<User>>();

        expectedUserAgeToUsersResult.put(19, List.of(bryan));
        expectedUserAgeToUsersResult.put(20, List.of(max, petr));
        expectedUserAgeToUsersResult.put(21, List.of(dima, alex));

        Map<Integer, List<User>> actualUsersAgeToUsersResult = User.groupUsers(users);

        assertEquals(expectedUserAgeToUsersResult, actualUsersAgeToUsersResult);
    }
}

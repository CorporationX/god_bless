package faang.school.godbless.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private static final byte AGE_BY_1 = 1;
    private static final byte AGE_BY_2 = 2;
    private static final byte AGE_BY_5 = 5;
    private static final String USER_NAME_TEST1 = "Test1";
    private static final String USER_NAME_TEST2 = "Test2";
    private static final String USER_NAME_TEST3 = "Test3";
    private static final String USER_NAME_TEST4 = "Test4";
    private static final String USER_NAME_TEST5 = "Test5";

    @Test
    void groupUsersTest() {
        Map<Byte, List<User>> actual = User.groupUsers(getUsers());

        assertEquals(3, actual.size());

        assertAll("Grouped users by age 1",
            () -> assertTrue(actual.containsKey(AGE_BY_1)),
            () -> assertEquals(3, actual.get(AGE_BY_1).size()),
            () -> assertTrue(actual.get(AGE_BY_1).stream().anyMatch(user -> user.getName().equals(USER_NAME_TEST1))),
            () -> assertTrue(actual.get(AGE_BY_1).stream().anyMatch(user -> user.getName().equals(USER_NAME_TEST4))),
            () -> assertTrue(actual.get(AGE_BY_1).stream().anyMatch(user -> user.getName().equals(USER_NAME_TEST5)))
        );

        assertAll("Grouped users by age 3",
            () -> assertTrue(actual.containsKey(AGE_BY_2)),
            () -> assertEquals(1, actual.get(AGE_BY_2).size()),
            () -> assertTrue(actual.get(AGE_BY_2).stream().anyMatch(user -> user.getName().equals(USER_NAME_TEST2)))
        );

        assertAll("Grouped users by age 5",
            () -> assertTrue(actual.containsKey(AGE_BY_5)),
            () -> assertEquals(1, actual.get(AGE_BY_5).size()),
            () -> assertTrue(actual.get(AGE_BY_5).stream().anyMatch(user -> user.getName().equals(USER_NAME_TEST3)))
        );
    }

    private List<User> getUsers() {
        return List.of(
            User.builder().name(USER_NAME_TEST1).age(AGE_BY_1).job("job").address("address").build(),
            User.builder().name(USER_NAME_TEST2).age(AGE_BY_2).job("job").address("address").build(),
            User.builder().name(USER_NAME_TEST3).age(AGE_BY_5).job("job").address("address").build(),
            User.builder().name(USER_NAME_TEST4).age(AGE_BY_1).job("job").address("address").build(),
            User.builder().name(USER_NAME_TEST5).age(AGE_BY_1).job("job").address("address").build()
        );
    }
}
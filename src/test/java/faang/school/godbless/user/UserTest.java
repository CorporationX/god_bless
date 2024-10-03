package faang.school.godbless.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {

    @Test
    void testOneUser() {
        var u = new User("name", 1, "work", "a");
        var res = User.groupUsers(List.of(u));

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, res.size()),
                () -> Assertions.assertEquals(1, res.get(1).size()),
                () -> Assertions.assertTrue(res.get(1).contains(u))
        );
    }

    @Test
    void testFull() {
        var u1 = new User("name1", 1, "work1", "a1");
        var u2 = new User("name2", 1, "work2", "a2");
        var u3 = new User("name3", 2, "work3", "a3");
        var u4 = new User("name4", 2, "work4", "a4");
        var u5 = new User("name5", 3, "work5", "a5");
        var users = List.of(u1, u2, u3, u4, u5);

        var res = User.groupUsers(users);

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, res.size()),
                () -> Assertions.assertEquals(2, res.get(1).size()),
                () -> Assertions.assertTrue(res.get(1).containsAll(List.of(u1, u2))),
                () -> Assertions.assertEquals(2, res.get(1).size()),
                () -> Assertions.assertTrue(res.get(2).containsAll(List.of(u3, u4))),
                () -> Assertions.assertEquals(2, res.get(1).size()),
                () -> Assertions.assertTrue(res.get(3).contains(u5))
        );
    }

    @Test
    void testEmptyList() {
        var res = User.groupUsers(List.of());
        Assertions.assertTrue(res.isEmpty());
    }

    @Test
    void testNull() {
        var res = User.groupUsers(null);
        Assertions.assertTrue(res.isEmpty());
    }

}

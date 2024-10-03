package faang.school.godbless.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {

    @Test
    void testOneUser() {
        var u = new User("name", 19, "Uber", "London");
        var res = User.groupUsers(List.of(u));

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, res.size()),
                () -> Assertions.assertEquals(1, res.get(19).size()),
                () -> Assertions.assertTrue(res.get(19).contains(u))
        );
    }

    @Test
    void testFull() {
        var u1 = new User("name1", 20, "Uber", "London");
        var u2 = new User("name2", 20, "Amazon", "Amsterdam");
        var u3 = new User("name3", 30, "Uber", "New York");
        var u4 = new User("name4", 30, "Amazon", "London");
        var u5 = new User("name5", 40, "Google", "London");
        var users = List.of(u1, u2, u3, u4, u5);

        var res = User.groupUsers(users);

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, res.size()),
                () -> Assertions.assertEquals(2, res.get(20).size()),
                () -> Assertions.assertTrue(res.get(20).containsAll(List.of(u1, u2))),
                () -> Assertions.assertEquals(2, res.get(30).size()),
                () -> Assertions.assertTrue(res.get(30).containsAll(List.of(u3, u4))),
                () -> Assertions.assertEquals(1, res.get(40).size()),
                () -> Assertions.assertTrue(res.get(40).contains(u5))
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

    @Test
    void testValidUser() {
        var name = "Name";
        var age = 18;
        var job = "Uber";
        var address = "London";

        Assertions.assertDoesNotThrow(() -> new User(name, age, job, address));
    }

    @Test
    void testEmptyName() {
        var name = "";
        var age = 18;
        var job = "Uber";
        var address = "London";

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("name must not be empty", e.getMessage());
    }

    @Test
    void testBlankName() {
        var name = " ";
        var age = 18;
        var job = "Uber";
        var address = "London";

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("name must not be empty", e.getMessage());
    }

    @Test
    void testNullName() {
        String name = null;
        var age = 18;
        var job = "Uber";
        var address = "London";

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("name must not be empty", e.getMessage());
    }

    @Test
    void testNotValidAge() {
        var name = "Name";
        var age = 17;
        var job = "Uber";
        var address = "London";

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("age must be over 18", e.getMessage());
    }

    @Test
    void testNotValidJob() {
        var name = "Name";
        var age = 18;
        var job = "";
        var address = "London";

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("job must be a valid value", e.getMessage());
    }

    @Test
    void testNullJob() {
        var name = "Name";
        var age = 18;
        String job = null;
        var address = "London";

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("job must be a valid value", e.getMessage());
    }

    @Test
    void testNotValidAddress() {
        var name = "Name";
        var age = 18;
        var job = "Uber";
        var address = "";

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("address must be a valid value", e.getMessage());
    }

    @Test
    void testNullAddress() {
        var name = "Name";
        var age = 18;
        var job = "Uber";
        String address = null;

        var e = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, age, job, address));
        Assertions.assertEquals("address must be a valid value", e.getMessage());
    }

}

package faang.school.godness.group.users;

import faang.school.godbless.group.users.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class UserTest {

    @Test
    void testGroupUsers() {

        User timofei = new User("Timofei", 30, "Amazon", "London, Beiker street");
        User maria = new User("Maria", 24, "Google", "Berlin");
        User roman = new User("Roman", 24, "Sber", "Moscow");

        List<User> users = List.of(timofei, maria, roman);

        Map<Integer, List<User>> ageUserMap = User.groupUsers(users);
        Assertions.assertEquals(List.of(timofei), ageUserMap.get(30));
        Assertions.assertEquals(List.of(maria, roman), ageUserMap.get(24));

    }
}

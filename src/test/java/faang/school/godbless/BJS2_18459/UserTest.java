package faang.school.godbless.BJS2_18459;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void groupUsersTest() {
        User user1 = new User("Ivan", 10, "HR", "Moscow");
        User user2 = new User("Sergey", 20, "PM", "Petersburg");
        User user3 = new User("Anton", 30, "Seller", "Ekaterinburg");
        User user4 = new User("Nikita", 20, "It", "Moscow");
        User user5 = new User("Igor", 30, "Director", "Vladivostok");
        User user6 = new User("Anna", 10, "Cook", "Paris");
        User user7 = new User("Elena", 30, "Manager", "London");
        User user8 = new User("Egor", 20, "Producer", "Milan");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6, user7, user8);

        var expected = users.stream().collect(Collectors.groupingBy(User::getAge));

        assertEquals(expected, User.groupUsers(users));
    }
}
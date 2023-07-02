package faang.school.godbless.iron_throne;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roles = List.of("Knight", "Mage");
        House house = new House("House", roles, 2);

        User user1 = new User("User 1");
        User user2 = new User("User 2");
        User user3 = new User("User 3");
        User user4 = new User("User 4");
        User user5 = new User("User 5");

        user1.joinHouse(house,roles.get(1));
        user2.joinHouse(house,roles.get(0));
        user3.joinHouse(house,roles.get(1));
        user1.leaveHouse(house,roles.get(1));
        user4.joinHouse(house,roles.get(1));
    }
}

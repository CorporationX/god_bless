package faang.school.godbless.iron_tron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("Knight");
        roles.add("Archer");
        roles.add("Mage");

        House house = new House("Stark", roles);
        var random = house.getRandom().nextInt(10000);

        List<User> users = Arrays.asList(
                new User("Jon Snow"),
                new User("Arya Stark"),
                new User("Robert Barateon"),
                new User("Chel from Gori"));

        users.forEach(user -> new Thread(() -> {
            user.joinHouse(house);
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse(house);
        }).start());
    }
}

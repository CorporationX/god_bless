package faang.school.godbless.iron_tron;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("Knight");
        roles.add("Archer");
        roles.add("Mage");

        House house = new House("Stark", roles);
        var random=house.getRandom().nextInt(10000);

        User user1 = new User("Jon Snow");
        User user2 = new User("Arya Stark");
        User user3 = new User("Robert Barateon");
        User user4 = new User("Chel from Gori");

        new Thread(() -> {
            user2.joinHouse(house);
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user2.leaveHouse(house);
        }).start();


        new Thread(() -> {
            user1.joinHouse(house);
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user1.leaveHouse(house);
        }).start();


        new Thread(() -> {
            user3.joinHouse(house);
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user3.leaveHouse(house);
        }).start();


        new Thread(() -> {
            user4.joinHouse(house);
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user4.leaveHouse(house);
        }).start();

    }
}

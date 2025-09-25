package school.faang.house;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        House house = new House("Starks");

        List<User> users = Arrays.asList(
                new User("Арья"),
                new User("Джон"),
                new User("Санса"),
                new User("Тирион"),
                new User("Бран")
        );

        List<Thread> threads = new ArrayList<>();
        for (User user : users) {
            user.setHouse(house);
            Role[] roles = Role.values();
            Role randomRole = roles[(int) (Math.random() * roles.length)];
            user.setRole(randomRole);
            Thread thread = new Thread(user);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все игроки покинули дом.");

    }
}

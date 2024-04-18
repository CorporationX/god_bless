package faang.school.godbless.IronThrone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        List<House> houses = getHouses();
        List<User> users = getUsers();

        Random random = new Random();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        for (User user : users) {
            pool.execute(() -> {
                user.joinHouse(houses.get(random.nextInt(houses.size())));
                try {
                    Thread.sleep(random.nextInt(1000, 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        }
        pool.shutdown();

        while (!pool.awaitTermination(10, TimeUnit.SECONDS)) ;
    }

    private static List<House> getHouses() {
        List<String> starkRoles = new ArrayList<>(Arrays.asList("Lord", "Lady", "Knight", "Maester"));
        List<String> lannisterRoles = new ArrayList<>(Arrays.asList("Lord", "Lady", "Knight", "Sellsword"));
        List<String> targaryenRoles = new ArrayList<>(Arrays.asList("Queen", "King", "Dragonrider", "Hand of the Queen"));
        List<String> baratheonRoles = new ArrayList<>(Arrays.asList("King", "Queen", "Knight", "Master at Arms"));
        List<String> tyrellRoles = new ArrayList<>(Arrays.asList("Lord", "Lady", "Knight", "Maester"));

        return List.of(new House("Stark", 3, starkRoles),
                new House("Lannister", 3, lannisterRoles),
                new House("Targaryen", 1, targaryenRoles),
                new House("Baratheon", 2, baratheonRoles),
                new House("Tyrell", 1, tyrellRoles)
        );
    }

    private static List<User> getUsers() {
        return Arrays.asList(
                new User("Ned Stark", "Lord"),
                new User("Cersei Lannister", "Lady"),
                new User("Daenerys Targaryen", "Queen"),
                new User("Robert Baratheon", "King"),
                new User("Margaery Tyrell", "Lady"),
                new User("Jon Snow", "Knight"),
                new User("Tyrion Lannister", "Imp"),
                new User("Viserys Targaryen", "Prince"),
                new User("Renly Baratheon", "Knight"),
                new User("Olenna Tyrell", "Queen")
        );
    }
}

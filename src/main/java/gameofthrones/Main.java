package gameofthrones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> roles = new ArrayList<>(Arrays.asList("Lord", "Knight", "Septa", "Maester"));
        House house = new House(roles);

        List<User> users = Arrays.asList(
                new User("Arya"),
                new User("Jon"),
                new User("Tyrion"),
                new User("Daenerys"),
                new User("Bran")
        );

        List<Thread> threads = new ArrayList<>();

        for (User user : users) {
            user.setHouse(house);
            Thread thread = new Thread(user);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

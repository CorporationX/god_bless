package Multithreading.bc3008;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();

        Collections.addAll(roles, "Role1", "Role2", "Role3", "Role4", "Role5");

        House house = new House(roles, roles.size());

        List<User> users = List.of(new User("User1"), new User("User2"),
                new User("User3"), new User("User4"),
                new User("User5"), new User("User6"), new User("User7"));


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (User user : users) {
            executorService.execute(() -> user.joinLeaveHouse(house));
        }

        executorService.shutdown();

    }
}

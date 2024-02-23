package faang.school.godbless.ironthrone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Long.MAX_VALUE;

public class Main {
    private static final int NUM_THREADS = 1;

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Charlie"));
        users.add(new User("David"));
        users.add(new User("Emily"));
        users.add(new User("Frank"));
        users.add(new User("Grace"));
        users.add(new User("Henry"));
        users.add(new User("Ivy"));
        users.add(new User("Jack"));

        House house = new House();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        users.forEach((user -> executorService.submit(() -> {
            Role role = Role.values()[new Random().nextInt(Role.values().length)]; //Created to generate a random role for a user
            user.joinHouse(house, role);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse();
        })));
        executorService.shutdown();
        try {
            executorService.awaitTermination(MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

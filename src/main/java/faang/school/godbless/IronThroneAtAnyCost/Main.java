package faang.school.godbless.IronThroneAtAnyCost;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    private static final int NUM_THREADS = 1;
    //private static final Random RANDOM = new Random();
    //private static final ExecutorService execute = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        House house = new House(getRoles(), "Lanister");

        getUsers().forEach((user) -> executorService.submit(() -> user.joinHouse(house)));

        executorService.shutdown();
        try {
            executorService.awaitTermination(2, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("execute.awaitTermination() in main was interrupted while waiting " + e);
        }
    }

    public static List<String> getRoles() {
        return Arrays.asList(
                "r1",
                "r2",
                "r3",
                "r4"
        );
    }

    public static List<User> getUsers() {
        return List.of(
                new User("1"),
                new User("2"),
                new User("3"),
                new User("4"),
                new User("5"),
                new User("6"),
                new User("7")
        );
    }
}

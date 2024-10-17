package bjs2_35743;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TOTAL_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS);

        Map<String, Integer> roles = new HashMap<>() {{
            put("Mage", 2);
            put("Swordsman", 1);
            put("Lord", 1);
        }};
        int availableRolesAmount = roles.values().stream()
                .reduce(0, (sum, num) -> sum += num);
        House house = new House(roles, availableRolesAmount);

        User jeff = new User("Jeff");
        User john = new User("John");
        User jack = new User("Jack");
        User josh = new User("Josh");
        User jane = new User("Jane");
        ;
        userJoinHouseExecutorService(executorService, jeff, house, "Swordsman");
        userJoinHouseExecutorService(executorService, john, house, "Mage");
        userJoinHouseExecutorService(executorService, jack, house, "Lord");
        userJoinHouseExecutorService(executorService, josh, house, "Mage");
        userJoinHouseExecutorService(executorService, jane, house, "Mage");
        executorService.submit(josh::leaveHouse);

        executorService.shutdown();

        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Timeout reached. Forcing shutdown...");
            executorService.shutdownNow();
        }
    }

    public static void userJoinHouseExecutorService(ExecutorService executorService, User user,
                                                    House house, String role) {
        executorService.submit(() -> {
            try {
                user.joinHouse(house, role);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

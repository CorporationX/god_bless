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

        List<Role> availableRoles = new ArrayList<>() {{
            add(Role.Swordsman);
            add(Role.Mage);
            add(Role.Lord);
            add(Role.Mage);
            add(Role.Mage);
        }};

        int availableRolesAmount = 5;
        House house = new House(availableRoles, availableRolesAmount);

        User jeff = new User("Jeff");
        User john = new User("John");
        User jack = new User("Jack");
        User josh = new User("Josh");
        User jane = new User("Jane");
        ;
        userJoinHouseExecutorService(executorService, jeff, house, Role.Swordsman);
        userJoinHouseExecutorService(executorService, john, house, Role.Mage);
        userJoinHouseExecutorService(executorService, jack, house, Role.Lord);
        userJoinHouseExecutorService(executorService, josh, house, Role.Mage);
        userJoinHouseExecutorService(executorService, jane, house, Role.Mage);
        executorService.submit(josh::leaveHouse);

        executorService.shutdown();

        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Timeout reached. Forcing shutdown...");
            executorService.shutdownNow();
        }
    }

    public static void userJoinHouseExecutorService(ExecutorService executorService, User user,
                                                    House house, Role role) {
        executorService.submit(() -> {
            try {
                user.joinHouse(house, role);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

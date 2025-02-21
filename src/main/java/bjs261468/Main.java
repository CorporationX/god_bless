package bjs261468;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final int TASKS_COMPLETED_DURATION_MS = 1000;

    public static void main(String[] args) {
        House firstHouse = new House();
        List<User> users = List.of(
                new User("User1", Role.DEFAULT_WITHOUT_ROLE),
                new User("User2", Role.DEFAULT_WITHOUT_ROLE),
                new User("User3", Role.DEFAULT_WITHOUT_ROLE),
                new User("User4", Role.DEFAULT_WITHOUT_ROLE),
                new User("User5", Role.DEFAULT_WITHOUT_ROLE),
                new User("User6", Role.DEFAULT_WITHOUT_ROLE));

        Map<Role, Integer> roleToLimit = firstHouse.getRoleToLimit();
        fillMapRoleToLimit(roleToLimit);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        users.forEach(user -> {
            try {
                user.joinHouse(firstHouse, Role.LORD);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        users.forEach(user -> executorService.submit(() -> {
            try {
                Set<Role> setRoles = new HashSet<>(Arrays.asList(Role.values()));
                firstHouse.releaseRole(getRandomClass(setRoles));
                user.joinHouse(firstHouse, getRandomClass(roleToLimit.keySet()));
                Set<User> setUsers = new HashSet<>(users);
                User randomUser = getRandomClass(setUsers);
                firstHouse.assignRole(getRandomClass(setRoles), ThreadLocalRandom.current().nextInt(3));
                randomUser.leaveHouse();
            } catch (InterruptedException e) {
                LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                        Thread.currentThread().getName());
                throw new RuntimeException(e);
            }
        }));
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TASKS_COMPLETED_DURATION_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("Waiting for the completion of tasks in the ExecutorService is interrupted in the thread {}",
                    Thread.currentThread().getName());
            executorService.shutdownNow();
        }
    }

    private static void fillMapRoleToLimit(Map<Role, Integer> roleToLimit) {
        roleToLimit.put(Role.MAGE, 3);
        roleToLimit.put(Role.LORD, 3);
        roleToLimit.put(Role.WARRIOR, 3);
        roleToLimit.put(Role.ARCHITECT, 3);
        roleToLimit.put(Role.DOCTOR, 3);
        roleToLimit.put(Role.TRADER, 3);
    }

    private static <T> T getRandomClass(Set<T> set) {
        if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException("Set cannot be null or empty");
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(set.size());
        int i = 0;
        for (T element : set) {
            if (i == randomIndex) {
                return element;
            }
            i++;
        }
        throw new IllegalStateException("Random element not found in Set");
    }
}

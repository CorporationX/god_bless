package BJS2_73230;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int USERS_COUNT = 7;
    private static final int SPENDING_TIME_IN_HOUSE = 3;
    private static final int EXECUTORS_TIMEOUT = 20;

    @SneakyThrows
    public static void main(String[] args) {
        final List<String> roles = List.of("admin", "user", "teacher", "student");
        final List<User> users = List.of(
                new User("Lada"),
                new User("Daniyal"),
                new User("Vika"),
                new User("Dasha"),
                new User("Misha"),
                new User("Sasha"),
                new User("Masha"),
                new User("Eva"),
                new User("Katya"),
                new User("Kirill"),
                new User("Tanya"),
                new User("Putin")
        );

        final House house = new House(roles);
        final ExecutorService executor = Executors.newFixedThreadPool(USERS_COUNT);

        for (int i = 0; i < users.size(); i++) {
            int finalI = i;
            executor.execute(() -> {
                final User user = users.get(finalI);
                user.joinHouse(house);
                spendTimeInHouse(SPENDING_TIME_IN_HOUSE);
                user.leaveHouse(house);
            });
        }

        executor.shutdown();
        awaitTime(executor, EXECUTORS_TIMEOUT);
        releaseRoles(roles, house);
    }

    private static void releaseRoles(List<String> roles, House house) {
        for (String role : roles) {
            house.releaseRole(role);
        }
    }

    private static void awaitTime(ExecutorService executor, long timeout) throws InterruptedException {
        if (executor.awaitTermination(timeout, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    @SneakyThrows
    private static void spendTimeInHouse(int spendingTime) {
        TimeUnit.SECONDS.sleep(spendingTime);
    }
}

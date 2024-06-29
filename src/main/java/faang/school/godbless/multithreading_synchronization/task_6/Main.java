package faang.school.godbless.multithreading_synchronization.task_6;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_COUNT = 8;
    private static final int TIME_OUT = 30;
    private static final int USER_JOIN_DURATION_MS = 5000;

    public static void main(String[] args) {
        final House house = new House(RolesProvider.getRoles());
        final List<User> users = UserProvider.getUsers(house);
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        users.forEach(user -> executor.submit(() -> {
            user.joinHouse();
            try {
                Thread.sleep(USER_JOIN_DURATION_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse();
        }));
        users.forEach(user -> executor.submit(user::leaveHouse));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Program finished successfully");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }
    }
}

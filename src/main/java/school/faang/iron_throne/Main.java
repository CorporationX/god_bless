package school.faang.iron_throne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREADS_COUNT = 6;

    public static void main(String[] args) {
        House house = new House("Liquid");
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 1; i <= THREADS_COUNT; i++) {
            int copyI = i;
            executor.submit(() -> {
                if (copyI % 2 == 0) {
                    house.addRole("Role " + copyI);
                }
                User user = new User("User " + copyI);
                user.joinHouse(house);
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Mission complete");
            } else {
                System.out.println("Something went wrong...");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

package school.faang.throne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Random random = new Random();
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        House house = new House("Throne House", 2);
        List<String> names = List.of("John", "Emily", "Michael");
        List<String> roles = List.of("Homeowner", "housekeeper", "cook");
        List<User> users = new ArrayList<>();
        for (int i=0; i<names.size(); i++) {
            User user = new User(names.get(i), roles.get(i));
            users.add(user);
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < 10; i++) {
            User user = users.get(random.nextInt(users.size()));
            executor.submit(() -> {
                try {
                    user.joinHouse(house);
                    Thread.sleep(5_000);
                    user.leaveHouse(house);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                System.out.println("Emergency stop.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

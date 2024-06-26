package faang.school.godbless.multithreading.tron;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        House house = new House(new ArrayList<>(List.of(
                "Глава",
                "Придворный"
        )));

        List<User> users = new ArrayList<>(List.of(
                new User("Сидорович", house),
                new User("Меченый", house),
                new User("Дегтярёв", house)
        ));

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (User user : users) {
            executor.submit(() -> {
                user.joinHouse();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        }

        executor.shutdown();
        try {
            boolean isTerminated = executor.awaitTermination(60, TimeUnit.SECONDS);
            System.out.println("Потоки завершены: " + isTerminated);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.multithreading.thron;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREAD = 4;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        House lannisters = new House("Lannisters");

        User david = new User("David", lannisters);
        User carl = new User("Carl", lannisters);
        User megan = new User("Megan", lannisters);
        User joy = new User("Joy", lannisters);

        List<User> users = Arrays.asList(david, carl, megan, joy);

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREAD);
        for (User user : users) {
            service.execute(() -> {
                try {
                    user.joinHouse();
                    TimeUnit.SECONDS.sleep(RANDOM.nextInt(3));
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

package faang.school.godbless.thirdSprint.GameOfTheThrones;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        House house = new House(new HashMap<>() {{
            put("knight", 3);
            put("lord", 2);
            put("mage", 1);
        }});

        for (int i = 0; i < NUM_THREADS; i++) {
            User user = new User("User" + i, "knight", house);
            service.execute(() -> {
                user.joinHouse();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                    return;
                }
                user.leaveHouse();
            });
        }
        service.shutdown();

        try {
            service.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
    }
}

package school.faang.irontron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House stark = new House(new ArrayList<>(Arrays.asList("lord", "warrior", "mage")));
        User knight = new User("Den", null, null);
        User knight2 = new User("Jack", null, null);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                knight.joinHouse(stark, "warrior");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            knight.leaveHouse();
        });

        executorService.submit(() -> {
            try {
                knight2.joinHouse(stark, "warrior");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });



        executorService.shutdown();
        executorService.awaitTermination(2000, TimeUnit.SECONDS);
    }
}

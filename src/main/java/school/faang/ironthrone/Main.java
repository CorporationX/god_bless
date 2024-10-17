package school.faang.ironthrone;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House(Arrays.asList("Knight", "Mage", "Archer"));
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                User user = new User(Thread.currentThread().getName());
                try {
                    user.joinHouse(house);
                    Thread.sleep(4000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        service.shutdown();
        try {
            if (!service.awaitTermination(20, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted +" +
                    " e.getMessage()");
        }
    }
}
package school.faang.IronThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House(new ArrayList<>(List.of("Archer", "Swordsman", "Mage")));

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            User user = new User("User " + i);
            service.submit(() -> {
                try {
                    user.joinHouse(house);
                    Thread.sleep(2000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    user.leaveHouse();
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
            throw new IllegalStateException("Thread has been interrupted +", e);
        }

    }
}

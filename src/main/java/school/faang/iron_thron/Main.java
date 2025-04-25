package school.faang.iron_thron;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = new House();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            users.add(new User("User" + i));
        }

        final int countThreads = 7;

        ExecutorService service = Executors.newFixedThreadPool(countThreads);

        for (int i = 0; i < users.size(); i++) {
            int finalI = i;
            service.submit(() -> {
                try {
                    User user = users.get(finalI);
                    user.joinHouse(house);

                    Thread.sleep(1000);

                    user.leaveHouse(house);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток был прерван, завершаем работу");
                }
            });
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}

package school.faang.multithreading.synchronize.bjs2_92466;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ivan"),
                new User("Olga"),
                new User("Anton"),
                new User("Kolya"),
                new User("Nina"),
                new User("Elena"),
                new User("Mariya"),
                new User("Yura"),
                new User("Boris")
        );

        final House starkHouse = new House(
                new ArrayList<>(Arrays.asList(
                        "Северный воин",
                        "Разведчик дозора",
                        "Хранитель севера",
                        "Вороновод",
                        "Старший строитель"
                ))
        );

        final ExecutorService executorService = Executors.newFixedThreadPool(users.size());

        users.forEach(user -> executorService.execute(() -> {
            user.joinHouse(starkHouse);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse();
        }));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

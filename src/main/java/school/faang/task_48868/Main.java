package school.faang.task_48868;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;

    @SneakyThrows
    public static void main(String[] args) {
        House house = new House("House-1", Arrays.asList(Role.LORD, Role.KNIGHT, Role.MAGE));
        List<User> users = Arrays.asList(new User("User1"), new User("User2"), new User("User3"));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        users.forEach(user -> executorService.execute(() -> {
            user.joinHouse(house);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Ошибка потока: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            user.leaveHouse();
        }));

        executorService.shutdown();

        if (executorService.awaitTermination(15, TimeUnit.SECONDS)) {
            log.info("Все пользователи завершили действия.");
        } else {
            log.warn("Принудительное завершение потоков.");
            executorService.shutdownNow();
        }
    }
}
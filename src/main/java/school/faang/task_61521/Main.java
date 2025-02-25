package school.faang.task_61521;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final House starkHouse = new House(Arrays.asList("Лорд", "Рыцарь", "Маг"));
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<User> users = new ArrayList<>();
        users.add(new User("Пользователь 1"));
        users.add(new User("Пользователь 2"));
        users.add(new User("Пользователь 3"));
        users.add(new User("Пользователь 4"));
        users.add(new User("Пользователь 5"));
        users.add(new User("Пользователь 6"));
        users.add(new User("Пользователь 7"));

        for (User user : users) {
            executorService.submit(() -> {
                try {
                    user.joinHouse(starkHouse);
                    Thread.sleep(5000); // Имитация времени в доме (2 секунды)
                } catch (InterruptedException e) {
                    log.error("Ошибка в потоке: " + e.getMessage());
                    Thread.currentThread().interrupt(); // Восстанавливаем флаг
                } finally {
                    user.leaveHouse(); // Убедимся, что освобождение роли выполнится
                }
            });
        }

        // Завершение работы ExecutorService
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Принудительное завершение, если не завершились за 60 секунд
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt(); // Восстанавливаем флаг
        }

        log.info("Все пользователи освободили свои роли.");
    }
}

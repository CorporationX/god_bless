package school.faang.game;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int MAX_WAIT_MINUTES = 2;
    private static final int MIN_SLEEP_MS = 0;
    private static final int MAX_SLEEP_MS = 10000;

    public static void main(String[] args) throws InterruptedException {
        List<String> rolesA = Arrays.asList("Роль1", "Роль2", "Роль3", "Роль4");
        House houseA = new House("ДомA", rolesA);

        List<String> rolesB = Arrays.asList("Роль2-1", "Роль2-2", "Роль2-3");
        House houseB = new House("ДомB", rolesB);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 20; i++) {
            User user = new User("Игрок_" + i);
            House selectHouse = ThreadLocalRandom.current().nextBoolean() ? houseA : houseB;
            executor.submit(() -> {
                try {
                    user.joinHouse(selectHouse);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_SLEEP_MS, MAX_SLEEP_MS));
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Все игроки завершили игру");
            } else {
                log.error("Не все игроки закончили за отведенное время {}мин. Завершаем принудительно...",
                        MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Ожидание завершения игры прервано.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
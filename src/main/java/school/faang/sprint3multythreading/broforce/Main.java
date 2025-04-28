package school.faang.sprint3multythreading.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final Double EARN_POINTS_PROBABILITY = 0.5;
    private static final Double LOSE_LIFE_PROBABILITY = 0.5;

    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 200; i++) {
            boolean earnedPoints = ThreadLocalRandom.current().nextDouble() < EARN_POINTS_PROBABILITY;
            boolean lostLife = ThreadLocalRandom.current().nextDouble() < LOSE_LIFE_PROBABILITY;

            executor.submit(() -> game.update(earnedPoints, lostLife));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                log.error("Прерывание потока во время задержки при симуляции шага игры.");
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                log.error("Задачи не завершились за 2 мин, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван во время ожидания, принудительно останавливаем пул...");
            executor.shutdownNow();
        }
    }
}
package school.faang.multithreading.asynchronism.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WorldOfWarcraft {
    private static final int MAX_TIME_WORK = 5;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executorService);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executorService);

        player1Quest.thenAccept(player -> log.info("Игрок: {} успешно завершил квест", player.getName()));
        player2Quest.thenAccept(player -> log.info("Игрок: {} успешно завершил квест", player.getName()));

        executorService.shutdown();
        try {
            executorService.awaitTermination(MAX_TIME_WORK, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Произошла ошибка: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

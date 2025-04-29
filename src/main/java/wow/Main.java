package wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 2;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        QuestSystem questSystem = new QuestSystem(executor);

        Player dan = new Player("Dan", 3, 200);
        Player dude = new Player("Dude", 21, 4500);

        Quest defeatSauron = new Quest("Defeat Sauron", 5000, 1000);
        Quest dropDataBase = new Quest("Drop database", 1, 0);

        questSystem.startQuest(dan, dropDataBase)
                .thenAccept(player -> printQuestResult(player.getName(),
                        dropDataBase.getName(),
                        player.getExperience()));
        questSystem.startQuest(dude, defeatSauron)
                .thenAccept(player -> printQuestResult(player.getName(),
                        defeatSauron.getName(),
                        player.getExperience()));

        softShutdown(executor);

    }

    private static void printQuestResult(String playerName, String questName, int playerExp) {
        System.out.printf("Player %s completed quest %s and now he has %d experience points%n",
                playerName, questName, playerExp);
    }

    private static void softShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Thread isn t terminated in time! Forced Shutdown!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Player thread is interrupted! {}", e.getCause().getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}

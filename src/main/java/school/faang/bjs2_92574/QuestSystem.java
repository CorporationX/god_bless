package school.faang.bjs2_92574;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static final long ONE_SECOND_IN_MILLIS = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * ONE_SECOND_IN_MILLIS);
                synchronized (player) {
                    int newExp = player.getExperience() + quest.getReward();
                    player.setExperience(newExp);
                }
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Квест был прерван!", e);
            }
        }, executorService);
    }

    public void shutdown() {
        System.out.println("Начал завершение QuestSystem...");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            } else {
                System.out.println("Потоки корректно завершены");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            System.out.println("Поток прерван, принудительное выключение");
        }
    }
}

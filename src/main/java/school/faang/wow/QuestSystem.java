package school.faang.wow;

import java.util.concurrent.*;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<Player> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Квест " + quest.getName() + " начался...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new IllegalStateException("Ошибка в потоке: " + e.getMessage());
                    }
                    System.out.println("Квест " + quest.getName() + "  выполнен.");
                    player.setExperience(player.getExperience() + 1);
                    return player;
                }, executorService);

        executorService.shutdown();

        return completableFuture;
    }
}

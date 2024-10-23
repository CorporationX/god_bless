package school.faang.wow;

import java.util.concurrent.*;

public class QuestSystem {
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture
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
    }
}

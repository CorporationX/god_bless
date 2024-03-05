package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " started the quest - " + quest.getName() + "!");

            try {
                Thread.sleep(quest.getDifficulty() * 500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            player.updateExperience(quest);
            player.updateLevel(quest);

            return player;
        }, executorService);

    }

    public void shutdownExecutorService() {
        executorService.shutdown();
    }
}

package wow_1241;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.printf("Start quest '%s' fot player - %s", quest.getName(), player.getName() + "\n");
                        Thread.sleep(quest.getDifficulty() * 1000L);
                        return player;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Поток для выполнения квеста прерван");
                    }
                })
                .thenApply((result) -> {
                    result.setExperience((int) (Math.random() * 1000));
                    return result;
                });
    }
}
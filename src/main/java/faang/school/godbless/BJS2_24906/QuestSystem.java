package faang.school.godbless.BJS2_24906;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executorService) {

        return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(quest.getDifficulty() * 1000L);
                    return player;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }, executorService)
            .thenApply(p -> {
                p.setExperience(p.getExperience() + quest.getReward());
                return p;
            });
    }
}

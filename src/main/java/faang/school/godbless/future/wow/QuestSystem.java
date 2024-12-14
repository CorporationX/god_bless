package faang.school.godbless.future.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player.addExperience(quest.getReward());
        }, executorService);
    }
}

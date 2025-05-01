package school.faang.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class QuestSystem {

    private static final Executor executor = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);

                player.addExperience(quest.getRewardExp());

                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest was interrupted", e);
            }
        }, executor);
    }
}

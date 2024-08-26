package wow;

import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class QuestSystem {
    private static final int POOL_SIZE = 5;
    private final ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            player.addExperience(getExpForQuest(quest, player.getLevel()));
            return player;
        }, executorService);
    }

    private int getExpForQuest(@NonNull Quest quest, int playerLevel) {
        if (playerLevel > quest.getDifficulty()) {
            return quest.getReward() / 2;
        }
        if (playerLevel - quest.getDifficulty() > 5) {
            return quest.getReward() * 2;
        }
        return quest.getReward();
    }
}

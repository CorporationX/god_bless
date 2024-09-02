package faang.school.godbless.BJS227756;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class QuestSystem {
    private static final int POOL_SIZE = 5;
    private static final int DIFFICULTY_RANGE = 5;
    private static final int REWARD_SCALE = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            player.addExperience(getExpForQuest(quest, player.getLevel()));
            return player;
        }, executorService);
    }

    private int getExpForQuest(Quest quest, int playerLevel) {
        if (playerLevel > quest.getDifficulty()) {
            return quest.getReward() / REWARD_SCALE;
        }
        if (playerLevel - quest.getDifficulty() > DIFFICULTY_RANGE) {
            return quest.getReward() * REWARD_SCALE;
        }
        return quest.getReward();
    }
}

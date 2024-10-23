package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class QuestSystem {
    /**
     * Starts a quest for the player by updating the player's experience based on the quest reward.
     *
     * @param player the player starting the quest
     * @param quest the quest to be started
     * @return a CompletableFuture representing the player's updated information after completing the quest
     */
    public CompletableFuture<Player> startQuest(Player player, Quest quest, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executor);
    }
}

package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> skilledPlayer = CompletableFuture.supplyAsync(() -> {
            player.setExperience(quest.getReward() + player.getExperience());
        })
    }
}

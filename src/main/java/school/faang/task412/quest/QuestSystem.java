package school.faang.task412.quest;

import school.faang.task412.player.Player;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                player.addExperience(quest.getReward());
                Thread.sleep(1000L * quest.getDifficulty());
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}

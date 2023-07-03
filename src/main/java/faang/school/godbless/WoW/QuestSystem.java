package faang.school.godbless.WoW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty().getDuration());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }

}

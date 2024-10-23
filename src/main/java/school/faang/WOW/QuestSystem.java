package school.faang.WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Something went wrong", e);
            }
            player.addExperience(quest.getReward()*quest.getDifficulty());
            return player;
        });
    }
}

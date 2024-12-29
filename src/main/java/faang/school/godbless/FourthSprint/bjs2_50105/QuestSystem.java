package faang.school.godbless.FourthSprint.bjs2_50105;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> playerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.getExperience().addAndGet(quest.getReward());
            return player;
        });
        return playerCompletableFuture;
    }
}

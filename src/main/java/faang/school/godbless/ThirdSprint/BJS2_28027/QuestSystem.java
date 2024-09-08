package faang.school.godbless.ThirdSprint.BJS2_28027;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player.increaseExp(quest.getReward());
        });
    }
}

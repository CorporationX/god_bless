package faang.school.godbless.sprint4.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (player.getLevel() < quest.getDifficulty()) {
            return CompletableFuture.failedFuture(
                    new IllegalArgumentException("Can't start this quest, level is not high enough!")
            );
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * quest.getDifficulty());
            } catch(InterruptedException e) {
                throw new RuntimeException("Quest interrupted!");
            }

            player.gainExperience(quest.getReward());
            return player;
        });
    }
}

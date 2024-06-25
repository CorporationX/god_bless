package faang.school.godbless.multithreading_2.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    player.increaseExperience(quest.getReward());
                    return player;
                }
        );
    }
}

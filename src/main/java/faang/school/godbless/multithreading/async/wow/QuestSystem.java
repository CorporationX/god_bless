package faang.school.godbless.multithreading.async.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final long QUEST_TIME = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * QUEST_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted in quest", e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}

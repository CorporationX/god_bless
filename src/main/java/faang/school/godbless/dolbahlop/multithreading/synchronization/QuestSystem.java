package faang.school.godbless.dolbahlop.multithreading.synchronization;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 800L);
                player.setExperience(player.getExperience() + quest.getReward());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}

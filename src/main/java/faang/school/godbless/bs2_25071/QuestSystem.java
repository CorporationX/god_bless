package faang.school.godbless.bs2_25071;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1_000L * quest.getDifficulty());
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
            return player.increaseExperienceAndGet(quest.getReward());
        });
    }
}

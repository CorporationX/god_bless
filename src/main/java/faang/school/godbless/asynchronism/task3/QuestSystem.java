package faang.school.godbless.asynchronism.task3;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int difficultyMultiplier = quest.getDifficulty().ordinal() + 1;
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " выполняет квест " + quest.getName());
            try {
                Thread.sleep(1000L * difficultyMultiplier);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        }).thenApply(playerFuture -> {
            playerFuture.setExperience(playerFuture.getExperience() + quest.getReward());
            return playerFuture;
        });
    }
}

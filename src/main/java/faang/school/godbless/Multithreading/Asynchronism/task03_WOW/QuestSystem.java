package faang.school.godbless.Multithreading.Asynchronism.task03_WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Is interrupt");
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.supplyAsync(() -> player).thenApply(player1 -> {
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}

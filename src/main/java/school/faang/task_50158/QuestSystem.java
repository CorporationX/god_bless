package school.faang.task_50158;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            player.addExperience(quest.getReward());
            return player;
        });
        questFuture.thenAccept(player0 -> System.out.println(player.getName()
                + " has completed the quest and now has " + player.getExperience() + " experience points "
                + Thread.currentThread().getName())).join();
        return questFuture;
    }
}
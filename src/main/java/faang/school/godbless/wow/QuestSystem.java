package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int delay = quest.getDifficulty() * 1000;
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }

    public CompletableFuture<Player> futureResult(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = startQuest(player, quest);

        questFuture.thenApply(completedPlayer -> completedPlayer.getName() + " completed and received " + completedPlayer.getExperience() + " points")
                .thenAccept(System.out::println);

        return questFuture;
    }
}


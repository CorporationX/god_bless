package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s started quest %s%n", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.addExperience(quest.getReward());
                System.out.printf("%s completed quest %s%n", player.getName(), quest.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}

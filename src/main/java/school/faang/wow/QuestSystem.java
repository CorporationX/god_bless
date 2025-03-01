package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                int questTime = quest.getDifficulty() * 1000;
                Thread.sleep(questTime);
                System.out.println("The quest difficulty time: " + questTime + "ms");
                player.addExperience(quest.getReward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest was interrupted", e);
            }
            return player;
        });
    }
}

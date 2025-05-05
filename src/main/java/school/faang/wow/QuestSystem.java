package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final int MILLIS = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " начал квест: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * MILLIS);
                player.addExperience(quest.getReward());
                System.out.println(player.getName() + " завершил квест: " + quest.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}

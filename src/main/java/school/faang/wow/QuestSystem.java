package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.println("Starting quest for Player: " + player.getName());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalStateException("Quest system thread interrupted ...");
            }
            player.addExperience();
            return player;
        });
    }
}

package Multithreading.bc3053_WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Quest");
            player.setExperience(player.getExperience() + quest.getReward());
            System.out.println("I'm here");
            return player;
        });
    }
}

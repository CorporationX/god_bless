package school.faang.WOW;

import java.util.concurrent.CompletableFuture;

class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {

                Thread.sleep(quest.getDifficulty() * 1000L);

                player.addExperience(quest.getReward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}
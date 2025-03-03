package school.faang.task_63915;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new QuestExecutionException("Поток прерван!", e);
            }
            return new Player(player.getName(), player.getLevel(),
                    player.addExperience(quest.getReward()));
        });
    }
}

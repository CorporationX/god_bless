package faang.school.godbless.BJS2_5927;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> future = isEmptyElements(player, quest);
        if (future != null) {
            return future;
        }

        return CompletableFuture.runAsync(() -> doQuest(quest)).thenApplyAsync(result -> {
            player.setExperience(player.getExperience() + quest.getDifficulty());
            return player;
        });
    }

    private CompletableFuture<Player> isEmptyElements(Player player, Quest quest) {
        if (player == null || quest == null) {
            CompletableFuture<Player> future = new CompletableFuture<>();
            if (player == null) {
                future.completeExceptionally(new IllegalArgumentException("Player cannot be null"));
            } else {
                future.completeExceptionally(new IllegalArgumentException("Quest cannot be null"));
            }
            return future;
        }
        return null;
    }

    private void doQuest(Quest quest) {
        try {
            Thread.sleep(1_000L * quest.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

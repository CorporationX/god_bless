package faang.school.godbless.wow;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Player> playerAfterQuest = CompletableFuture.supplyAsync(() -> {
            if (player.getLevel() > quest.difficulty()) {
                try {
                    Thread.sleep(quest.difficulty() * 1_000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                player.setExperience(player.getExperience() + quest.reward());
            }
            return player;
        }, executorService);
        executorService.shutdown();
        return playerAfterQuest;
    }
}

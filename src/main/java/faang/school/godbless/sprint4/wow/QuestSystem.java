package faang.school.godbless.sprint4.wow;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class QuestSystem {
    private ExecutorService executor;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> player, executor)
                .thenApply(skilledPlayer -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    skilledPlayer.setExperience(skilledPlayer.getExperience() + quest.getReward());
                    return skilledPlayer;
                });
    }
}

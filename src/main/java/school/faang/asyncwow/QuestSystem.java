package school.faang.asyncwow;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class QuestSystem {
    private final ExecutorService executor;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.addExperience(quest.getReward());
            return player;
        }, executor);
    }
}

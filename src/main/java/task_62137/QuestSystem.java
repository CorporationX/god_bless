package task_62137;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new IllegalStateException("Quest interrupted while sleeping for difficulty: "
                        + quest.getDifficulty(), e);
            }
            player.addExperience(quest.getDifficulty());
            return player;
        });
    }
}

package school.faang.task49960;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.difficulty().getSecond());

                player.setExperience(quest.difficulty().getSecond() + quest.reward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Error message: ", e);
            }
            return player;
        });
    }
}

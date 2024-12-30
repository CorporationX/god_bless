package school.faang.task_50124;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() * 1000L);
                player.addExperience(quest.reward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread {} was interrupted while processing {} and {}",
                        Thread.currentThread().getName(), player, quest);
                throw new CompletionException(e);
            }
            return player;
        }).thenApply(updatedPlayer -> {
            log.info("{}  has completed the quest and now has {} experience points.",
                    updatedPlayer.getName(), updatedPlayer.getExperience());
            return updatedPlayer;
        });
    }

}

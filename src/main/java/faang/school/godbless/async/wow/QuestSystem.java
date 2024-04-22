package faang.school.godbless.async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000L);
                    } catch (InterruptedException e) {
                        log.error("Player was interrupted during quest executing.", e);
                    }

                    return player;
                })
                .thenApply((questExecutor) -> questExecutor.gainExperience(quest.getReward()))
                .thenApply((questExecutor) -> {
                    log.info(questExecutor.getName() + " has completed the quest " + quest.getTitle() + "  and now has " + quest.getReward() + " experience points.");
                    return questExecutor;
                });
    }
}

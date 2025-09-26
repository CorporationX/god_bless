package school.faang.bjs2_92615;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long TASK_DURATION = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.info("Quest starting {}", quest.name());

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} performs a quest..", player.getName());
                Thread.sleep(quest.difficulty() * TASK_DURATION);
                player.addExperience(quest.reward());
                log.info("Completed the quest! Experience: {}", player.getExperience());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("The quest has been interrupted", e);
            }
            return player;
        });
    }

    public CompletableFuture<String> startQuestWithStringResult(Player player, Quest quest) {
        return startQuest(player, quest)
                .thenApply(p -> p.getName() + " completed " + quest.name() + " with " +
                        p.getExperience() + " XP");
    }

    public CompletableFuture<Void> startQuestWithNotification(Player player, Quest quest) {
        return startQuest(player, quest)
                .thenAccept(p -> {
                    log.info("NOTIFICATION: {} completed a quest!", p.getName());
                });
    }
}



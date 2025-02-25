package school.faang.task_62236;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long MILLISECONDS_IN_SECOND = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} is starting the quest: {}", player.getName(), quest.name());
            try {
                Thread.sleep(quest.difficulty() * MILLISECONDS_IN_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Quest interrupted for player {}: {}", player.getName(), quest.name(), e);
                throw new RuntimeException("Quest interrupted", e);
            }
            player.addExperience(quest.reward());
            log.info("{} has completed the quest: {}", player.getName(), quest.name());
            return player;
        });
    }

    public void processQuestResult(CompletableFuture<Player> questFuture) {
        questFuture.thenAccept(player ->
                log.info("{} now has {} experience points.", player.getName(), player.getExperience()));
    }
}

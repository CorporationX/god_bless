package school.faang.task_62196;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int DEFAULT_EXP = 0;
    private static final int MILLISECONDS_IN_SECOND = 1_000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        String playerName = player.getName();
        String questName = quest.getName();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Player> playerFuture = CompletableFuture.supplyAsync(() -> {
            log.info(QuestMessage.START_QUEST.getMessage(), playerName, questName);
            try {
                int leadTime = quest.getDifficulty() * MILLISECONDS_IN_SECOND;
                Thread.sleep(leadTime);
                log.info(QuestMessage.END_QUEST.getMessage(), playerName, questName);
                return quest.getReward();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(QuestMessage.INTERRUPT_QUEST.getMessage(), questName);
                throw new RuntimeException("Поток был прерван", e);
            }
        }, executor)
                .exceptionally(ex -> {
                    log.error(QuestMessage.QUEST_ERROR.getMessage(), questName, playerName);
                    return DEFAULT_EXP;
                })
                .thenApply(reward -> {
                    synchronized (player) {
                        player.setExperience(player.getExperience() + reward);
                        log.info(
                                QuestMessage.GAIN_EXPERIENCE.getMessage(),
                                playerName, reward, questName, player.getExperience()
                        );
                        return player;
                    }
                });

        executor.shutdown();

        return playerFuture;
    }
}

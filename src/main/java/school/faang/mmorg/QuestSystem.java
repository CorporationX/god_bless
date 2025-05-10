package school.faang.mmorg;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int THREAD_AMOUNT = 4;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} is starting the quest {}", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * ONE_SECOND_IN_MS);
                player.addExperience(quest.getReward());
                log.info("{} has finished the quest {}", player.getName(), quest.getName());
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Quest interrupted for player: " + player.getName(), e);
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}

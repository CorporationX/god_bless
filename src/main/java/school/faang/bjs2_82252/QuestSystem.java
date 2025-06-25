package school.faang.bjs2_82252;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {

    private static final long MILLIS_IN_SECOND = 1000L;
    private static final int THREAD_POOL_SIZE = 4;

    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * MILLIS_IN_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(
                        "Quest execution interrupted for player %s on quest '%s'"
                                .formatted(player.getName(), quest.getName()), e);
            }

            player.addExperience(quest.getReward());
            return player;
        }, executorService);

        questFuture.thenAccept(p -> log.info(
                "{} has completed the quest and now has {} experience points.",
                p.getName(), p.getExperience()));

        return questFuture;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

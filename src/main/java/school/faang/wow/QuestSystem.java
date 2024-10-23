package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem implements AutoCloseable {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int questTime = calculateQuestTime(quest);
        log.info("{} starts quest '{}'", player.getName(), quest.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(questTime);
            } catch (InterruptedException e) {
                log.error("Caught exception", e);
                throw new IllegalStateException(
                        String.format("Thread %s interrupted", Thread.currentThread().getName()), e
                );
            }
            player.addExperience(quest.getReward());
            return player;
        }, executor);
    }

    private int calculateQuestTime(Quest quest) {
        return switch (quest.getDifficulty()) {
            case EASY -> 1_000;
            case MEDIUM -> 2_000;
            case HARD -> 3_000;
        };
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

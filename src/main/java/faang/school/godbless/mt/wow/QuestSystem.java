package faang.school.godbless.mt.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int THREAD_COUNT = 10;
    private static final long TIME_FOR_DIFFICULT = 10000;

    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * TIME_FOR_DIFFICULT);
                player.addExperience(quest.getReward());
                return player;
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e);
                throw new IllegalStateException("Thread interrupted", e);
            }
        }, executor);
    }
}

package school.faang.bjs274601;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int THREAD_COUNT = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficult().getTime());
                synchronized (player) {
                    player.addExperience(quest.getReward().getExperience());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Quest interrupted for {}", player.getName());
            }
            return player;
        }, executorService);
    }
}

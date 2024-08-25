package faang.school.godbless.BJS2_18357;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} is starting quest {}", player.getName(), quest.getName());
                Thread.sleep(1000L * quest.getDifficulty());
                player.setExperience(player.getExperience() + quest.getReward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Something gone wrong with the thread: {}", e.getMessage());
            }
            return player;
        }, executorService);
    }

    public static void shutdown(){
        executorService.shutdown();
    }
}

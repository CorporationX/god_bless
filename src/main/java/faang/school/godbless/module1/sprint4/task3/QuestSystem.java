package faang.school.godbless.module1.sprint4.task3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private final ExecutorService service = Executors.newCachedThreadPool();


    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> questCompleted(player, quest), service);
    }

    private Player questCompleted(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty() * 1000L);
        } catch (InterruptedException e) {
            log.error("Method questCompleted broken {}", e.getMessage());
            throw new RuntimeException(e);
        }
        player.setExperience(player.getExperience() + quest.getReward());
        return player;
    }

    public void shutdownAllThreads(){
        service.shutdown();
    }
}

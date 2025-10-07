package school.faang.bjs2_92608;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    private QuestSystem() {

    }

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("игрок {} выполняет квест \"{}\" уровня {}...", player.getName(), quest.getName(),
                        quest.getDifficult());
                TimeUnit.SECONDS.sleep(quest.getDifficult().getDifficultScore());
                log.info("игрок {} прошел квест!", player.getName());
                player.increaseExperience(quest.getReward());
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, EXECUTOR);
    }
}

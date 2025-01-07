package school.faang.sprint4.task_50185;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        return CompletableFuture.supplyAsync(() -> completeQuest(player, quest));
    }

    private Player completeQuest(Player player, Quest quest) {
        log.debug("The quest {} has started", quest);
        try {
            Thread.sleep(1000L * quest.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        player.setExperience(player.getExperience() + quest.getReward());
        return player;
    }

    public void shutDown() {
        executorService.shutdown();
    }
}

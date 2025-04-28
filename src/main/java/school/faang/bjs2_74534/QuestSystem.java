package school.faang.bjs2_74534;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Getter
public class QuestSystem {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.info("start quest to \"{}\" on \"{}\"", player.getName(), quest.name());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() * 1000);
            } catch (InterruptedException e) {
                log.error("start quest interrupted: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            ;
            return player.addExperience(quest.reward());
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}

package school.faang.wow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private static final Logger logger = LoggerFactory.getLogger(QuestSystem.class);
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("{} начал выполнение квеста: {}", player.getName(), quest.name);
                TimeUnit.SECONDS.sleep(quest.difficulty);
                logger.info("{} завершил квест: {}", player.getName(), quest.name);
                player.addExperience(quest.reward);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Ошибка выполнения квеста: {}", quest.name, e);
            }
            return player;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
        final boolean done;
        try {
            done = executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.debug("Все квесты выполнены? {}", done);
    }
}
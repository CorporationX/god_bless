package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final long SECONDS_IN_MILLISECONDS = 1000;
    private static final int THREAD_COUNT = 2;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("игрок {} приступил к выполнению задания {}", player.getName(), quest.name());
                Thread.sleep(quest.difficulty() * SECONDS_IN_MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Error!!!!!!!!!!!!");
            }
            log.info("игрок {} выполнил задание {} и получил {} опыта", player.getName(), quest.name(), quest.reward());
            player.addExp(quest.reward());
            return player;
        }, executorService);
    }
}

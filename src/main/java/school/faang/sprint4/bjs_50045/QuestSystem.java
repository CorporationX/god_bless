package school.faang.sprint4.bjs_50045;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int THREADS_AMOUNT = 2;
    private static final long MILLISECOND = 1000;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREADS_AMOUNT);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Игрок {} начал выполнение задания {}", player.getName(), quest.getName());
            try {
                Thread.sleep(quest.getDifficulty() * MILLISECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Поток был прерван");
                throw new RuntimeException();
            }
            player.setExperience(player.getExperience() + quest.getReward());

            EXECUTOR.shutdown();

            return player;
        }, EXECUTOR);
    }
}

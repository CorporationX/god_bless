package school.faang.bjs2_82245;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final int NUM_THREAD = 4;
    private static final int TIMEOUT = 10;
    private final ExecutorService poolThread = Executors.newFixedThreadPool(NUM_THREAD);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        Random random = new Random();
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Игрок {} начал выполнение квеста \"{}\"", player.getName(), quest.getName());
                    try {
                        TimeUnit.SECONDS.sleep(random.nextInt(7));
                    } catch (InterruptedException e) {
                        log.error("Квест {} прерван", quest.getName(), e);
                        throw new RuntimeException("Прервано выполнение квеста", e);
                    }
                    log.info("Игрок {} выполнил квест \"{}\"!", player.getName(), quest.getName());
                    return quest.getReward();
                },
                poolThread)
                .thenApplyAsync(reward -> {
                    player.gainExperience(reward);
                    return player;
                });
    }

    public void breakPoolThread() {
        poolThread.shutdown();
        try {
            if (!poolThread.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Досрочное завершение работы потоков");
                poolThread.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolThread.shutdownNow();
        }
    }
}

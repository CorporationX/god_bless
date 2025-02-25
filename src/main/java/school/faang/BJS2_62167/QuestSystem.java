package school.faang.BJS2_62167;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final ExecutorService executor = Executors.newFixedThreadPool(ConstAndMessage.THREAD_COUNT);
    private final List<CompletableFuture<Void>> activeQuests = new CopyOnWriteArrayList<>();

    public void startQuest(@NonNull Player player, @NonNull Quest quest) {


        CompletableFuture<Void> questFuture = CompletableFuture.supplyAsync(() -> {
            log.info(ConstAndMessage.PLAYER_STARTED_QUEST, player.getName(), quest.getName());
            try {
                Thread.sleep(ConstAndMessage.QUEST_TIMEOUT * quest.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info(ConstAndMessage.PLAYER_COMPLETED_QUEST, player.getName(), quest.getName());
            player.addExperience(quest.getReward());
            return player;
        }, executor).thenAccept(p -> log.info(ConstAndMessage.PLAYER_EXPERIENCE_POINTS,
                p.getName(), p.getExperience()));
        activeQuests.add(questFuture);
    }

    public void waitForCompletionQuest() {
        log.info(ConstAndMessage.WAITING_ALL_QUESTS_FINISH);
        CompletableFuture.allOf(activeQuests.toArray(new CompletableFuture[0])).join();
        log.info(ConstAndMessage.ALL_QUESTS_FINISHED);
    }

    public static void shutdown() {
        log.info(ConstAndMessage.SHUTTING_DOWN_MESSAGE);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(ConstAndMessage.SHUTTING_DOWN_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

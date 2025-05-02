package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final long QUEST_TIME_MULTIPLIER = 1000L;
    private static final int EXP_MULTIPLIER = 10;
    private static final ExecutorService questExecutor = Executors.newCachedThreadPool();
    private static final long MAX_WAIT_MINUTES = 1;

    static synchronized CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.println(player.getName() + " has started the quest " + quest.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * QUEST_TIME_MULTIPLIER);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + (quest.getDifficulty() * EXP_MULTIPLIER));
            System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() +
                    " experience points.");
            return player;
        }, questExecutor);
    }

    public static void shutdown() {
        questExecutor.shutdown();
        try {
            if (!questExecutor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Not all tasks are completed in {} minutes. Attempting to force stop", MAX_WAIT_MINUTES);
                questExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Waiting for threads to finish is interrupted.");
            questExecutor.shutdownNow();
        }
    }

}

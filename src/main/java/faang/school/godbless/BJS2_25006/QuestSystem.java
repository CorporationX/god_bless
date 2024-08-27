package faang.school.godbless.BJS2_25006;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {

    private final int THREAD_POOL_SIZE = 2;
    private final int EXPERIENCE_TO_LEVEL_UP = 200;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
            int experience = player.getExperience() + quest.getReward();
            
            if (experience > player.getLevel() * EXPERIENCE_TO_LEVEL_UP) {
                player.setLevel(experience / EXPERIENCE_TO_LEVEL_UP);
                player.setExperience(experience - player.getLevel() * EXPERIENCE_TO_LEVEL_UP);

            } else {
                player.setExperience(experience);
            }
            return player;
        }, executorService);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

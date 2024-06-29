package faang.school.godbless.sprint3.wow;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
@Slf4j
public class QuestSystem {

    private final ExecutorService executorService;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            boolean isDoneQuest = false;

            try {
                Thread.sleep(2L);
                isDoneQuest = true;
            } catch (InterruptedException e) {
                log.info("{} is interrupted", Thread.currentThread().getName());
            } finally {
                log.info("result quest: " + isDoneQuest);
                return isDoneQuest;
            }
        }, executorService).thenApply(result -> {
            if (result) {
                synchronized (player.getLock()) {
                    log.info("Thread in sync: " + Thread.currentThread().getName());
                    player.setExperience(player.getExperience() + (quest.getReward() * quest.getDifficulty()));
                    player.setLevel(player.getLevel() + 1);
                }
            }

            return player;
        });
    }

    private boolean isValidParameters(Player player, Quest quest) {
        if (player == null || quest == null) {
            throw new IllegalArgumentException("Can't be nullable objects");
        }

        return true;
    }
}

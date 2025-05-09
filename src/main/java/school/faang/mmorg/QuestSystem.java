package school.faang.mmorg;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int ONE_SECOND_IN_MS = 1_000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} is starting the quest {}", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * ONE_SECOND_IN_MS);
                player.addExperience(quest.getReward());
                log.info("{} has finished the quest {}", player.getName(), quest.getName());
                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
    }
}

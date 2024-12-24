package school.faang.task_49983;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Start quest: {}", quest);
            try {
                int questTime = quest.getDifficulty() * 1000;
                Thread.sleep(questTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Quest: {} ended", quest);
            player.increaseExperience(quest.getReward());
            return player;
        });
    }
}

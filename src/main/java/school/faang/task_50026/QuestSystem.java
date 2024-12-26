package school.faang.task_50026;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (player.getLevel() < quest.getDifficulty()) {
                    log.error("{} не может начать квест: {} Рекомендуемый уровень: {}",
                            player.getName(), quest.getName(), quest.getDifficulty());
                    return player;
                }
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
                player.addExperience(quest.getReward());
                log.info("{} завершил квест: {}", player.getName(), quest.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Quest interrupted for player: {}", player.getName());
            }
            return player;
        });
    }
}
package school.faang.BJS2_63994;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} начал квест: {}", player.getName(), quest.getName());

            try {
                Thread.sleep(1000 * quest.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Квест не выполнен", e);
                return player;
            }

            player.setExperience(player.getExperience() + quest.getReward());
            log.info("{} завершил квест и получил {} опыта.", player.getName(), quest.getReward());
            return player;
        });
    }
}

package school.faang.task_62196;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int DEFAULT_EXP = 0;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Игрок \"{}\" приступил к выполнению задания \"{}\"", player.getName(), quest.getName());
            try {
                int leadTime = quest.getDifficulty() * 1000;
                Thread.sleep(leadTime);
                return quest.getReward();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Поток был прерван", e);
            }
        })
                .exceptionally(ex -> {
                    log.error("Произошла ошибка при выполнении квеста \"{}\"", quest.getName());
                    return DEFAULT_EXP;
                })
                .thenApply(reward -> {
                    player.setExperience(player.getExperience() + reward);
                    return player;
                });
    }
}

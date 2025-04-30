package school.faang.sprint4_future_async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 100L);
            } catch (InterruptedException e) {
                log.error("ОШIБКА прерывания во время выполнения сна!!!", e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
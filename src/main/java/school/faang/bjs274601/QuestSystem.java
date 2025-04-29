package school.faang.bjs274601;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficult().getTime());
                player.addExperience(quest.getReward().getExperience());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Quest interrupted for {}", player.getName());
            }
            return player;
        });
    }
}

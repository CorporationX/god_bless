package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest)  {
        CompletableFuture<Player> completableFuture = CompletableFuture.supplyAsync(() -> {
            log.debug("{} started {}", player, quest);
            try {
                Thread.sleep(10000 * quest.getDifficulty() / player.getLevel());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        return completableFuture;
    }
}

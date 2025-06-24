package school.faang.bjs2_82252;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getReward());
            return player;
        });

        questFuture.thenAccept(player1 -> {
            log.info("{} has completed the quest and now has {} experience points.",
                    player1.getName(), player1.getExperience());
        });
        return questFuture;
    }
}

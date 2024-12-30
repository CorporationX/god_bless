package school.faang.sprint4.bjs_49997;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int QUEST_TIME = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) quest.difficulty() * QUEST_TIME);
                player.setExperience(player.getExperience() + quest.reward());
            } catch (InterruptedException e) {
                log.error("Quest was interrupted");
            }
            return player;
        });
    }
}

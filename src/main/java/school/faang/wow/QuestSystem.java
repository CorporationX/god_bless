package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long QUEST_RUNNING_TIME = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * QUEST_RUNNING_TIME);
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted", Thread.currentThread().getName());
            }
            player.setExperience(quest.getReward() + player.getExperience());
            return player;
        });
    }
}

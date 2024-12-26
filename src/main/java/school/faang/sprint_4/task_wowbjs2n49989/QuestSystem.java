package school.faang.sprint_4.task_wowbjs2n49989;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> solveQuest(player, quest));
    }

    private Player solveQuest(Player player, Quest quest) {
        try {
            player.setExperience(player.getExperience() + quest.getReward());
            Thread.sleep(quest.getDifficulty());
            return player;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return player;
    }
}

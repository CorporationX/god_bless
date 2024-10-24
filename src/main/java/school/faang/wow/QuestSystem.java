package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(
                        () -> performQuest(player, quest))
                .thenApply(playerCompletedQuest -> {
                    playerCompletedQuest.getQuestReward(quest);
                    return playerCompletedQuest;
                });
    }

    public Player performQuest(Player player, Quest quest) {
        try {
            System.out.println(player.getName() + " выполняет квест " + quest.getName());
            TimeUnit.SECONDS.sleep(quest.getDifficulty());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
        return player;
    }
}

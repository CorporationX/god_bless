package school.faang_sprint_3.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        var threadPool = Executors.newFixedThreadPool(5);
        var futurePlayer = CompletableFuture.supplyAsync(() -> {
            timeForQuest(player, quest, quest.difficulty());
            player.addExp(quest.reward());
            return player;
        }, threadPool);
        threadPool.shutdown();
        return futurePlayer;
    }

    private void timeForQuest(Player player, Quest quest, Difficulty difficulty) {
        try {
            log.info("{} {} {} started", player.getName(), quest.name(), difficulty);
            switch (difficulty) {
                case EASY:
                    Thread.sleep(5000);
                    break;
                case MEDIUM:
                    Thread.sleep(10000);
                    break;
                case HARD:
                    Thread.sleep(15000);
                    break;
                default:
                    log.info("Unknown quest difficulty");
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while waiting for quest to be completed", e);
            throw new IllegalStateException(e);
        }
    }
}

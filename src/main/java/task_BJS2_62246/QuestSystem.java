package task_BJS2_62246;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long MILLIS = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        try {
            Thread.sleep(quest.getDifficulty() * MILLIS);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            log.info("Thread: {} was interrupted", Thread.currentThread().getName());
        }
        return CompletableFuture.supplyAsync(() -> {
            log.info("Игрок \"{}\" проходит квест \"{}\"", player.getName(), quest.getName());
            player.addExperience(quest.getReward());
            return player;
        });
    }
}

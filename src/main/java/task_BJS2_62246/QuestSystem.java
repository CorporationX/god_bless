package task_BJS2_62246;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        try {
            Thread.sleep(quest.getDifficulty() * 1000L);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            log.info("Thread: {} was interrupted", Thread.currentThread().getName());
        }

        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("Игрок \"%s\" проходит квест \"%s\"\n", player.getName(), quest.getName());
            player.addExperience(quest.getReward());
            return player;
        });
    }
}

package school.faang.bjs250065;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public static final long CONVERT_MS = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(quest.name() + " was running");

            try {
                Thread.sleep(quest.difficulty() * CONVERT_MS);
            } catch (InterruptedException e) {
                log.error("The tread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }

            player.setExperience(player.getExperience() + quest.reward());
            return player;
        });
    }
}
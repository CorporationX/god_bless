package school.faang.bjs250164;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    private static final int SECONDS = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Quest started: " + quest.getName());
            try {
                Thread.sleep((long) quest.getDifficulty() * SECONDS);
            } catch (InterruptedException e) {
                log.error("Error while sleeping", e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}

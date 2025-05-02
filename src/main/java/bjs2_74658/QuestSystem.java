package bjs2_74658;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> playerFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
        return playerFuture;
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Arnold", 5, 320);
        Player player2 = new Player("Bobby", 4, 200);

        Quest quest1 = new Quest("Collect flowers", 2, 100);
        Quest quest2 = new Quest("Drive away the bandits", 5, 500);

        CompletableFuture<Player> player1Quest1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest2 = questSystem.startQuest(player2, quest2);

        player1Quest1.thenAccept(player -> log.info("{} completed the quest \"{}\", now his experience is: {}",
                player.getName(), quest1.getName(), player.getExperience()));
        player2Quest2.thenAccept(player -> log.info("{} completed the quest \"{}\", now his experience is: {}",
                player.getName(), quest2.getName(), player.getExperience()));

        CompletableFuture.allOf(player1Quest1, player2Quest2).join();
    }
}

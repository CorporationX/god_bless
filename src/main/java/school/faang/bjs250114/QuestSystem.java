package school.faang.bjs250114;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
                player.addExperience(quest.getReward());
                log.info("{} completed the quest with difficulty {} and received {} experience points.",
                        player.getName(), quest.getDifficulty(), quest.getReward());
                return player;

            } catch (Exception e) {
                log.error("An error occurred while completing the quest", e);
                throw new RuntimeException();
            }
        });
    }

    private void printQuestResult(Player player) {
        System.out.println("Quest completed by: " + player.getName()
                + "Experience points: " + player.getExperience());
    }

    public void handleQuestCompletion(CompletableFuture<Player> questFuture, Player player) {
        questFuture.thenAccept(result -> {
            printQuestResult(player);
        });

    }
}

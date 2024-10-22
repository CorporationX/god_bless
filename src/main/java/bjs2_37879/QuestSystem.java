package bjs2_37879;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public void processPlayerQuest(Player player, Quest quest) {
        CompletableFuture<Player> playerQuest = startQuest(player, quest);
        printQuestCompletionResults(playerQuest);
    }

    private CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int millisToSleep = 1000;

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(millisToSleep);
            } catch (InterruptedException e) {
                System.out.println("поймали исключение");
            }
            player.getQuestReward(quest);
            return player;
        });
    }

    private void printQuestCompletionResults(CompletableFuture<Player> playerQuest) {
        playerQuest.join();
        playerQuest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience() +
                " experience points."));
    }
}

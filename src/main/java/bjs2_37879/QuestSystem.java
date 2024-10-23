package bjs2_37879;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final int TOTAL_THREADS = 5;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TOTAL_THREADS);

    public void processAllPlayerQuests(List<PlayerQuest> playerQuests) {
        List<CompletableFuture<Player>> processedQuestFutures = playerQuests.stream()
                .map(playerQuest -> startQuest(playerQuest.getPlayer(), playerQuest.getQuest()))
                .toList();
        CompletableFuture.allOf(processedQuestFutures.toArray(new CompletableFuture[0])).join();
        EXECUTOR_SERVICE.shutdown();
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
            printQuestCompletionResults(player);
            return player;
        }, EXECUTOR_SERVICE);
    }

    private void printQuestCompletionResults(Player player) {
        System.out.println(player.getName() + " has completed the quest and now has " +
                player.getExperience() + " experience points.");
    }
}

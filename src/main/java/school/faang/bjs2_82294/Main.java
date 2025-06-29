package school.faang.bjs2_82294;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIME_AWAIT_TERMINATE_S = 5;
    private static final TimeUnit TIME_UNIT_S = TimeUnit.SECONDS;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 50);
        Player player2 = new Player("Sylvanas", 12, 40);

        Quest quest1 = new Quest("Defeat the Lich King", Difficulty.MEDIUM, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", Difficulty.EASY, 100);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executorService);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executorService);

        player1Quest.thenAccept(player ->
                System.out.printf("%s has completed the quest and now has %s level.%n",
                        player.getName(), player.getLevel()));
        player2Quest.thenAccept(player ->
                System.out.printf("%s has completed the quest and now has %s level.%n",
                        player.getName(), player.getLevel()));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIME_AWAIT_TERMINATE_S, TIME_UNIT_S)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdownNow();
        }
    }
}
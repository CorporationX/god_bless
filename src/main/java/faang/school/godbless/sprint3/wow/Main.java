package faang.school.godbless.sprint3.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = ExecutorUtils.getExecutorService();
        QuestSystem questSystem = new QuestSystem(executorService);

        Player player1 = new Player("player1", 0, 0);

        Quest quest1 = new Quest("quest1", 1, 1);
        Quest quest2 = new Quest("quest2", 1, 1);
        Quest quest3 = new Quest("quest3", 1, 1);
        Quest quest4 = new Quest("quest4", 1, 1);
        Quest quest5 = new Quest("quest5", 1, 1);

        CompletableFuture<Player> playerCompletableFuture1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> playerCompletableFuture2 = questSystem.startQuest(player1, quest2);
        CompletableFuture<Player> playerCompletableFuture3 = questSystem.startQuest(player1, quest3);
        CompletableFuture<Player> playerCompletableFuture4 = questSystem.startQuest(player1, quest4);
        CompletableFuture<Player> playerCompletableFuture5 = questSystem.startQuest(player1, quest5);

        playerCompletableFuture1.thenAccept(player -> System.out.println("thread in accept: " + Thread.currentThread().getName() + " . " + player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        playerCompletableFuture2.thenAccept(player -> System.out.println("thread in accept: " + Thread.currentThread().getName() + " . "  + player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        playerCompletableFuture3.thenAccept(player -> System.out.println("thread in accept: " + Thread.currentThread().getName() + " . "  + player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        playerCompletableFuture4.thenAccept(player -> System.out.println("thread in accept: " + Thread.currentThread().getName() + " . "  + player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        playerCompletableFuture5.thenAccept(player -> System.out.println("thread in accept: " + Thread.currentThread().getName() + " . "  + player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        ExecutorUtils.getExecutorService().shutdown();

        try {
            if (executorService.awaitTermination(10L, TimeUnit.SECONDS)) {
                System.out.println("All tasks hasn't done");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

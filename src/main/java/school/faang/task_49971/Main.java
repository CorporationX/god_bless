package school.faang.task_49971;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 20, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 5, 100);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        QuestSystem questSystem = new QuestSystem();
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executor);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executor);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

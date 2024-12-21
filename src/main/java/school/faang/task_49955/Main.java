package school.faang.task_49955;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(player1Quest, player2Quest);

        allTasks.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Error : " + exception.getMessage());
            } else {
                try {
                    System.out.println(player1Quest.get());
                    System.out.println(player2Quest.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        allTasks.join();
    }
}
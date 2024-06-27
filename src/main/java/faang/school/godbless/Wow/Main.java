package faang.school.godbless.Wow;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        QuestSystem questSystem = new QuestSystem(executorService);

        Player player1 = new Player("Player1", 1, 0);
        Player player2 = new Player("Player2", 1, 0);

        Quest quest1 = new Quest("Quest1", 2, 50);
        Quest quest2 = new Quest("Quest2", 3, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture.allOf(player1Quest, player2Quest).join();

        try {
            System.out.println(player1.getName() + " опыт: " + player1Quest.get().getExperience());
            System.out.println(player2.getName() + " опыт: " + player2Quest.get().getExperience());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Завершение ExecutorService
        executorService.shutdown();
    }
}

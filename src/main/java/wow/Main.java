package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int THREAD_SIZE = 2;

    public static void main(String[] args) {
        Quest quest = new Quest("Shadow fight", 4, 40);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_SIZE);
        QuestSystem questSystem = new QuestSystem(executorService);
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        CompletableFuture<Void> future1 = questSystem.startQuest(quest, player1)
                .thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        CompletableFuture<Void> future2 = questSystem.startQuest(quest, player2)
                .thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        CompletableFuture.allOf(future1, future2).join();
        executorService.shutdown();
        System.out.println("Вылазка окончена");
    }
}


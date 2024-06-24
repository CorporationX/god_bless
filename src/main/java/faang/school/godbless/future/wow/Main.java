package faang.school.godbless.future.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int THREADS = 4;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 2, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 5, 100);
        Quest quest3 = new Quest("quest3", 7, 120);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executorService);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executorService);
        CompletableFuture<Player> player2Quest3 = questSystem.startQuest(player2, quest3, executorService);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        player2Quest3.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));

        executorService.shutdown();
    }
}

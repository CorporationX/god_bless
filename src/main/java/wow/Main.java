package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_QUESTS = 2;
    private static final int AWAIT_SECONDS = 30;
    /**
     * The main entry point of the application. Initializes a quest system and two players,
     * assigns quests to the players, and starts the quests asynchronously.
     * Once a quest is completed, the player's name and updated experience points are printed.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_QUESTS);
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executorService);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executorService);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        executorService.shutdown();

        if (!executorService.awaitTermination(AWAIT_SECONDS, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}

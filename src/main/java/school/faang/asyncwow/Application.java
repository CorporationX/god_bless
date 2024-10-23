package school.faang.asyncwow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        QuestSystem questSystem = new QuestSystem(executor);

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 100, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 80, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        player1Quest.join();
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        player2Quest.join();
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        executor.shutdownNow();
    }
}

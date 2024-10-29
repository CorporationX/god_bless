package school.faang.sprint4.wow;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player2Quest1 = questSystem.startQuest(player2, quest1);

        player1Quest1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        player2Quest2.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        player2Quest1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));

        System.out.println("Main thread is not blocked. Waiting for result of quests...");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");;
        }
        System.out.println("\nMain thread has finished");
    }
}

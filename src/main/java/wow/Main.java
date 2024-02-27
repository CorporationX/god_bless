package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", "Hard", 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", "Easy", 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(updatedPlayer -> System.out.println(updatedPlayer.getName() +
                " has completed the quest and now has " + updatedPlayer.getExperience() +
                " experience points. Level: " + updatedPlayer.getLevel()));
        player2Quest.thenAccept(updatedPlayer -> System.out.println(updatedPlayer.getName() +
                " has completed the quest and now has " + updatedPlayer.getExperience() +
                " experience points. Level: " + updatedPlayer.getLevel()));

        try {
            player1Quest.join();
            player2Quest.join();
        } catch (CompletionException e) {
            e.printStackTrace();
        }
    }
}

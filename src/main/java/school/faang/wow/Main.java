package school.faang.wow;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        List<CompletableFuture<Player>> playersQuest = Arrays.asList(
                questSystem.startQuest(player1, quest1), questSystem.startQuest(player2, quest2));

        for (CompletableFuture<Player> completableFuture : playersQuest) {
            completableFuture.thenAccept((player) -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.")).join();
        }
    }
}

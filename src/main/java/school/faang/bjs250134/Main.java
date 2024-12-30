package school.faang.bjs250134;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("'Defeat the Lich King'", 10, 150);
        Quest quest2 = new Quest("'Retrieve the Sword of Azeroth'", 5, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        CompletableFuture.allOf(player1Quest, player2Quest).join();

        player1Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points."));
    }
}

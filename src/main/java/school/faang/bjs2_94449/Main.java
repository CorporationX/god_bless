package school.faang.bjs2_94449;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player ->
                System.out.printf("%s has completed the quest %s and now has %d experience points\n",
                        player.getName(),
                        quest1.name(),
                        player.getExperience()));
        player2Quest.thenAccept(player ->
                System.out.printf("%s has completed the quest %s and now has %d experience points\n",
                        player.getName(),
                        quest2.name(),
                        player.getExperience()));

    }
}

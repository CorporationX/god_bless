package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player playerOne = new Player("Thrall", 10, 250);
        Player playerTwo = new Player("Sylvanas", 12, 450);
        Quest questOne = new Quest("Defeat the Lich King", 10, 150);
        Quest questTwo = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        CompletableFuture<Player> playerOneQuest = questSystem.startQuest(playerOne, questOne);
        CompletableFuture<Player> playerTwoQuest = questSystem.startQuest(playerTwo, questTwo);
        playerOneQuest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has " + player.getExperience() + " experience points.")).join();
        playerTwoQuest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has " + player.getExperience() + " experience points.")).join();
    }
}
package faang.school.godbless.BJS2_25080;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 950);

        Quest quest1 = new Quest("Defeat the Lich King", Difficulty.HARD, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", Difficulty.MEDIUM, 100);

        CompletableFuture<Player> player1Quest = QuestSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = QuestSystem.startQuest(player2, quest2);
        CompletableFuture.allOf(player1Quest, player2Quest).join();

        System.out.println("Game Over!");
    }
}

package wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Sargeras");
        Player player2 = new Player("Lich King");
        Player player3 = new Player("Medivh");

        Quest quest1 = new Quest("creating a potion", 1, 10);
        Quest quest2 = new Quest("Defeat the Lich King", 3, 150);
        Quest quest3 = new Quest("Retrieve the Sword of Azeroth", 5, 100);

        CompletableFuture<Player> futurePlayer1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> futurePlayer2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> futurePlayer3 = questSystem.startQuest(player3, quest3);

        CompletableFuture.allOf(futurePlayer1, futurePlayer2, futurePlayer3)
                .thenRun(() -> {
                    System.out.println("\nAll players completed quests");
                    System.exit(0);
                });
    }
}

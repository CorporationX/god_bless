package school.faang.sprint4.bjs2_63654;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall");
        Player player2 = new Player("Sylvanas");

        Quest quest1 = new Quest("Defeat the Lich King", 2, 50);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 3, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}

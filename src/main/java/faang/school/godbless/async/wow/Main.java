package faang.school.godbless.async.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 2, 40);
        Player player2 = new Player("Sylvanas", 3, 600);

        Quest quest1 = new Quest("Defeat the Lich King", 5, 60);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 500);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}

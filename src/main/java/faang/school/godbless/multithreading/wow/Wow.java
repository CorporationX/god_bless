package faang.school.godbless.multithreading.wow;

import java.util.concurrent.CompletableFuture;

public class Wow {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Thrall", 0);
        Player player2 = new Player("Sylvanas", 0);
        Quest quest1 = new Quest("Defeat the Lich King", 3, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 2, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player ->
                System.out.printf("%s has completed the quest and now has level: %s and %s experience points.\n",
                        player1.getName(), player1.getLevel(), player1.getExperience()));
        player2Quest.thenAccept(player ->
                System.out.printf("%s has completed the quest and now has level: %s and %s experience points.\n",
                        player2.getName(), player2.getLevel(), player2.getExperience()));
        Player.endGame();
    }
}

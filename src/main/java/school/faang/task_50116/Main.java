package school.faang.task_50116;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        Player playerOne = player1Quest.join();
        printQuestCompletionMessage(playerOne);

        Player playerTwo = player2Quest.join();
        printQuestCompletionMessage(playerTwo);
    }

    public static void printQuestCompletionMessage(Player player) {
        System.out.printf(
                "%s has completed the quest and now has %s experience points.\n",
                player.getName(), player.getExperience()
        );
    }

}

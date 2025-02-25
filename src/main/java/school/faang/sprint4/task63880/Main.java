package school.faang.sprint4.task63880;

import java.util.concurrent.CompletableFuture;

public class Main {
    private static final String MESSAGE = "\n%s has completed the quest and now has %d experience points.";

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        System.out.print("\n----------------------------");
        player1Quest.thenAccept(player -> System.out.printf(MESSAGE, player.getName(), player.getExperience()));
        player2Quest.thenAccept(player -> System.out.printf(MESSAGE, player.getName(), player.getExperience()));
        player1Quest.join();
        player2Quest.join();
        System.out.println("\n-----------------------------");
    }
}

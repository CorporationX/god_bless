package faang.school.godbless.multithreading_async.BJS2_6511;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Player 1", 20, 250);
        Player player2 = new Player("Player 2", 51, 450);

        Quest quest1 = new Quest("Defeat the Dragon", 10, 150);
        Quest quest2 = new Quest("Convince the Dwarf", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(
                player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.")
        ).join();
        player2Quest.thenAccept(
                player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.")
        ).join();
    }
}

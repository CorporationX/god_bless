package school.faang.module1.sprint4.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvan", 12, 450);

        Quest quest1 = new Quest("Defeat the Rich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Zeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience() + " experience points."))
        ;
        player2Quest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
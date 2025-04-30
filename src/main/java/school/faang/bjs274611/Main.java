package school.faang.bjs274611;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 3, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 2, 100);

        CompletableFuture<Player> questFuture1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> questFuture2 = questSystem.startQuest(player2, quest2);

        questFuture1.thenAccept(player -> {
            System.out.println(player.getName() + " has completed the quest and now has " +
                    player.getExperience() + " experience points.");
        });

        questFuture2.thenAccept(player -> {
            System.out.println(player.getName() + " has completed the quest and now has " +
                    player.getExperience() + " experience points.");
        });

        CompletableFuture.allOf(questFuture1, questFuture2).join();
    }
}

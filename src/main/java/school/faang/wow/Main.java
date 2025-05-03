package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Boris", 1, 1);
        Player player2 = new Player("Vasya", 1, 1);

        Quest quest1 = new Quest("find luck", 10, 1000);
        Quest quest2 = new Quest("Kill frog", 1, 1);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> {
            System.out.printf("%s has completed the quest and now has %d experience points.",
                    player.getName(), player.getExperience());
        });
        player2Quest.thenAccept(player -> {
            System.out.printf("%s has completed the quest and now has %d experience points.%n",
                    player.getName(), player.getExperience());
        });

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}

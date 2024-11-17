package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class Game {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Aleksey", 11, 350);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        Quest quest3 = new Quest("Defeat the King", 90, 250);

        CompletableFuture<Player> player1Quest =
                questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest =
                questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player3Quest =
                questSystem.startQuest(player3, quest3);

        player1Quest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience()
                + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience()
                + " experience points."));
        player3Quest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience()
                + " experience points."));

        questSystem.shutdown();
    }
}

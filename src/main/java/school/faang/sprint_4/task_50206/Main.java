package school.faang.sprint_4.task_50206;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("First player", 3, 80);
        Player player2 = new Player("Second player", 5, 100);

        Quest quest1 = new Quest("Defeat the Lich King", 2, 50);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 3, 70);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));

        player1Quest.join();
        player2Quest.join();
    }
}

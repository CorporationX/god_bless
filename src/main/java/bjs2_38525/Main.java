package bjs2_38525;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Player> players = List.of(
                new Player("player1", 1, 20),
                new Player("player2", 14, 70),
                new Player("player3", 22, 204),
                new Player("player4", 2, 24),
                new Player("player5", 7, 111)
        );

        List<Quest> quests = List.of(
                new Quest("quest1", 1, 20),
                new Quest("quest2", 2, 5),
                new Quest("quest3", 3, 10),
                new Quest("quest4", 1, 25),
                new Quest("quest5", 1, 10)
        );

        for (int i = 0; i < players.size(); i++) {
            questSystem.startQuest(players.get(i), quests.get(i), service)
                    .thenAccept(player ->
                            System.out.println(player.getName() +
                                    " has completed the quest and now has " +
                                    player.getExperience() + " experience points."));
        }

        service.shutdown();
    }
}

package faang.school.godbless.wow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static QuestSystem questSystem = new QuestSystem();
    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 4, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 5, 100);

        start(player1, quest1);
        start(player2, quest2);

        executor.shutdown();
    }

    private static void start(Player player, Quest quest) {
        executor.submit(() -> {
            questSystem.startQuest(player, quest).thenAccept(p -> System.out.println(player.getName()
                    + " has completed the quest and now has " + player.getExperience() + " experience points."));
        });
    }
}

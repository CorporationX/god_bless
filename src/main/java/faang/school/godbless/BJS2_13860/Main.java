package faang.school.godbless.BJS2_13860;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        QuestSystem questSystem = new QuestSystem();

        // Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        // Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        questSystem.startQuest(player1, quest1, threadPool)
                .thenAccept(player -> {
                    System.out.println(player.getName() + " complete quest");
                    System.out.println(player.getName() + " experience: " + player.getExperience());
                });
        questSystem.startQuest(player2, quest2, threadPool)
                .thenAccept(player -> {
                    System.out.println(player.getName() + " complete quest");
                    System.out.println(player.getName() + " experience: " + player.getExperience());
                });

        threadPool.shutdown();
    }
}

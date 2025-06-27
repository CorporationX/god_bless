package school.faang.wow82282;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();
        ExecutorService questExecutor = Executors.newFixedThreadPool(2);

        Player player1 = new Player("Thrall", 3, 250);
        Player player2 = new Player("Sylvanas", 5, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 3, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 5, 100);

        try {
            Future<?> future1 = questExecutor.submit(() -> questSystem
                    .startQuest(player1, quest1)
                    .thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                            + player.getExperience() + " experience points."))
                    .join()
            );

            Future<?> future2 = questExecutor.submit(() -> questSystem
                    .startQuest(player2, quest2)
                    .thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                            + player.getExperience() + " experience points."))
                    .join()
            );
            future1.get();
            future2.get();
        } finally {
            questExecutor.shutdown();
        }
    }
}

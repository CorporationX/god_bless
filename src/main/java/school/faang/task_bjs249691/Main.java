package school.faang.task_bjs249691;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Ксюша");
        Player player2 = new Player("Кирилл");
        Player player3 = new Player("Тимур");
        Player player4 = new Player("Егор");

        Boss boss = new Boss(2);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> player1.fightBoss(boss));
        executorService.submit(() -> player2.fightBoss(boss));
        executorService.submit(() -> player3.fightBoss(boss));
        executorService.submit(() -> player4.fightBoss(boss));

        executorService.shutdown();
    }
}

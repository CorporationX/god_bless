package faang.school.godbless.Task_25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2, 0);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> new Player("John").startBattle(boss));
        executorService.execute(() -> new Player("Mike").startBattle(boss));
        executorService.execute(() -> new Player("Kevin").startBattle(boss));

        executorService.shutdown();

    }
}

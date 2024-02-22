package faang.school.godbless.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss1 = new Boss(5, 1);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int number = i;
            executorService.submit(() -> new Player("Player number" + number).startBattle(boss1));
        }
        executorService.shutdown();
    }
}

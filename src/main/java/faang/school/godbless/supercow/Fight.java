package faang.school.godbless.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fight {
    public static void main(String[] args) {
        Boss boss = new Boss(10, 9);
        Player firstPlayer = new Player("Fedor");
        Player secondPlayer = new Player("Andrey");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(() -> firstPlayer.startBattle(boss));
        executorService.execute(() -> secondPlayer.startBattle(boss));

        executorService.shutdown();
    }
}

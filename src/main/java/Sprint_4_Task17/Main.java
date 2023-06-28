package Sprint_4_Task17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player = new Player("Олег");
        Player player2 = new Player("Дмитрий");
        Player player3 = new Player("Роман");

        ExecutorService executor = Executors.newFixedThreadPool(2);
       player.startBattle(boss);
       player2.startBattle(boss);
       player3.startBattle(boss);
        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {boss.joinBattle(player);});
            executor.submit(() -> {boss.joinBattle(player2);});
            executor.submit(() -> {boss.joinBattle(player3);});
        }
        executor.shutdown();
    }
}

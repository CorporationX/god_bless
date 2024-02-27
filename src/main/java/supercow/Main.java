package supercow;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(6);
        Random rnd = new Random();

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        while(true){
            Player player1 = new Player("player " + (rnd.nextInt(100)));
            Player player2 = new Player("player " + (rnd.nextInt(100)));
            Player player3 = new Player("player " + (rnd.nextInt(100)));
            executorService.execute(() -> boss.joinBattle(player1));
            executorService.execute(() -> player1.startBattle(boss));
            executorService.execute(() -> boss.joinBattle(player2));
            executorService.execute(() -> player2.startBattle(boss));
            executorService.execute(() -> boss.joinBattle(player3));
            executorService.execute(() -> player3.startBattle(boss));
        }
    }
}

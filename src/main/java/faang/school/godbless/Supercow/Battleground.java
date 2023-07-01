package faang.school.godbless.Supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Battleground {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        Player player6 = new Player("Player6");
        Player player7 = new Player("Player7");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> player1.startBattle(boss));
        executorService.execute(() -> player2.startBattle(boss));
        executorService.execute(() -> player3.startBattle(boss));
        executorService.execute(() -> player4.startBattle(boss));
        executorService.execute(() -> player5.startBattle(boss));
        executorService.execute(() -> player6.startBattle(boss));
        executorService.execute(() -> player7.startBattle(boss));

        executorService.shutdown();
    }
}

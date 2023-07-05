package faang.school.godbless;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainBattle {
    public static void main(String[] args) {
        Boss boss = new Boss(5);

        List<Player> players = List.of(
                new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4"),
                new Player("Player5"),
                new Player("Player6"),
                new Player("Player7"),
                new Player("Player8")
        );

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (Player player: players){
            executor.execute(() -> player.startBattle(boss));
            try {
                Thread.sleep(1);
                executor.execute(() -> player.exitBattle(boss));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("Battle is over !");
    }
}

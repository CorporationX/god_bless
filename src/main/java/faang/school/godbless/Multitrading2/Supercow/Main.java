package faang.school.godbless.Multitrading2.Supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player player = new Player("max");
        Player player1 = new Player("max 1");
        Player player2 = new Player("max 2");
        Player player3 = new Player("max 3");
        Player player4 = new Player("max 4");
        Player player5 = new Player("max 5");

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> player.startBattle(boss));
        service.execute(() -> player1.startBattle(boss));
        service.execute(() -> player2.startBattle(boss));
        service.execute(() -> player3.startBattle(boss));
        service.execute(() -> player4.startBattle(boss));
        service.execute(() -> player5.startBattle(boss));

        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

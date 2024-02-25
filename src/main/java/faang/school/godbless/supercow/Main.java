package faang.school.godbless.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String... args) {
        Boss cow = new Boss(3);
        Player player1 = new Player("Jhon");
        Player player2 = new Player("Bill");
        Player player3 = new Player("Smith");
        Player player4 = new Player("Michel");
        Player player5 = new Player("Elon");

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> player1.startBattle(cow));
        executor.execute(() -> player2.startBattle(cow));
        executor.execute(() -> player3.startBattle(cow));
        executor.execute(() -> player4.startBattle(cow));
        executor.execute(() -> player5.startBattle(cow));
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Game over!");
    }
}

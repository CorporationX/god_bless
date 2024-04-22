package faang.school.godbless.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(MAX_PLAYERS);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Player vasya = new Player("Vasya");
        Player peter = new Player("Peter");
        Player kolya = new Player("Kolya");
        Player ivan = new Player("Ivan");
        Player nikita = new Player("Nikita");

        executor.execute(()->vasya.startBattle(boss));
        executor.execute(()->peter.startBattle(boss));
        executor.execute(()->kolya.startBattle(boss));
        executor.execute(()->ivan.startBattle(boss));
        executor.execute(()->nikita.startBattle(boss));

        executor.shutdown();
        System.out.println("has the processes ended?: " + executor.awaitTermination(30, TimeUnit.SECONDS));
    }
}

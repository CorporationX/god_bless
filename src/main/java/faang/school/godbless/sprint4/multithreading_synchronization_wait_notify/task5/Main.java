package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);
        Player player1 = new Player("Петер");
        Player player2 = new Player("Иван");
        Player player3 = new Player("Рогер");
        Player player4 = new Player("Ромуль");
        Player player5 = new Player("Сергь");
        Player player6 = new Player("Виктор");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> player1.startBattle(boss));
        executor.execute(() -> player2.startBattle(boss));
        executor.execute(() -> player3.startBattle(boss));
        executor.execute(() -> player4.startBattle(boss));
        executor.execute(() -> player5.startBattle(boss));
        executor.execute(() -> player2.deleteBattle(boss));
        executor.execute(() -> player6.startBattle(boss));
        executor.shutdown();

//        while (executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
//        }

        System.out.println("Done!");
    }
}

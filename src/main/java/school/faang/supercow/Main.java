package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);

        Player player1 = new Player("Player-1");
        Player player2 = new Player("Player-2");
        Player player3 = new Player("Player-3");
        Player player4 = new Player("Player-4");

        List<Thread> threads = new ArrayList<>();
        Thread thread1 = new Thread(() -> player1.doBattle(boss));
        Thread thread2 = new Thread(() -> player2.doBattle(boss));
        Thread thread3 = new Thread(() -> player3.doBattle(boss));
        Thread thread4 = new Thread(() -> player4.doBattle(boss));

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}

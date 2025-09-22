package school.faang.bjs2_90410;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3, 0);
        List<Player> players = List.of(
                new Player("Alex"),
                new Player("Mike"),
                new Player("Steve"),
                new Player("John"),
                new Player("Mark"),
                new Player("Peter")
        );
        Thread[] threads = new Thread[players.size()];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> players.get(finalI).doBattle(boss));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}

package school.faang.supercow;

import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(2);

        List<Player> playerList = List.of(new Player("Jon"), new Player("ben"),
                new Player("stiv"), new Player("stas"), new Player("bob"),
                new Player("peek"));

        Thread[] threads = new Thread[playerList.size()];
        IntStream.range(0, playerList.size())
                .forEach(index -> {
                    threads[index] = new Thread(() -> playerList.get(index).doBattle(boss));
                    threads[index].start();
                });
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

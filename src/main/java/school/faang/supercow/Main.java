package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(2);

        List<Player> playerList = List.of(new Player("Jon"), new Player("ben"),
                new Player("stiv"), new Player("stas"), new Player("bob"),
                new Player("peek"));

        Thread[] threads = new Thread[playerList.size()];
        for (int i = 0; i < playerList.size(); i++) {
            final int index = i;
            threads[i] = new Thread(() -> playerList.get(index).doBattle(boss));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package school.faang.supercow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player oleg = new Player("Oleg");
        Player dima = new Player("Dima");
        Player ivan = new Player("Ivan");
        Player player1 = new Player("Player1");
        List<Player> players = Collections.synchronizedList(List.of(oleg, dima, ivan, player1));
        List<Thread> threads = Collections.synchronizedList(new ArrayList<>());

        for (Player player : players) {
            Thread thread = new Thread(() -> player.doBattle(boss));
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

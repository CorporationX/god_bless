package school.faang.suprcow_BJS2_36774;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Boss boss = new Boss(3, 0);
        Player player1 = new Player("Steven");
        Player player2 = new Player("Petr");
        Player player3 = new Player("Robert");
        Player player4 = new Player("Joe");

        List<Player> players = new ArrayList<>(Arrays.asList(player1, player2, player3, player4));
        List<Thread> threads = new ArrayList<>();

        for (Player player : players) {
            threads.add(new Thread(() -> {
                try {
                    player.startBattle(boss);
                    Thread.sleep(500);
                    player.endBattle(boss);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

package faang.school.godbless.multithreading.synchronizationPractice.supercow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Boss boss = new Boss(5);

        List<Player> players = new ArrayList<>(Arrays.asList(
                new Player("player1"),
                new Player("player2"),
                new Player("player3"),
                new Player("player4"),
                new Player("player5"),
                new Player("player6"),
                new Player("player7"),
                new Player("player8"),
                new Player("player9"),
                new Player("player10")));

        for (Player player : players) {
            new Thread(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}

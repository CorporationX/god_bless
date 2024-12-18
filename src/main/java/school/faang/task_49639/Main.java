package school.faang.task_49639;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("игрок 1");
        Player player2 = new Player("игрок 2");
        Player player3 = new Player("игрок 3");

        List<Thread> threadsList = new ArrayList<>(List.of(new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })));

        for (Thread thread : threadsList) {
            thread.start();
        }
    }
}

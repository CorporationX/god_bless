package supercow_1097;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Boss boss = new Boss();
        List<Thread> threads = new ArrayList<>();
        int countPlayersToBoss = 10;

        for (int i = 1; i < countPlayersToBoss; i++) {
            int y = i;
            threads.add(new Thread(() -> startBattle(boss, "Player_" + y)));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void startBattle(Boss boss, String namePlayer) {
        boss.joinBattle(new Player(namePlayer));
    }
}
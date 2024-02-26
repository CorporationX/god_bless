package faang.school.godbless.supercow;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss();
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        while (true) {
            Player player = new Player("Player " + (int) (Math.random() * 100 + 1));
            Player player1 = new Player("Player " + (int) (Math.random() * 500 + 1));
            Player player2 = new Player("Player " + (int) (Math.random() * 1000 + 1));
            executor.execute(() -> boss.joinBattle(player));
            executor.execute(() -> player.startBattle(boss));
            executor.execute(() -> boss.joinBattle(player1));
            executor.execute(() -> player1.startBattle(boss));
            executor.execute(() -> boss.joinBattle(player2));
            executor.execute(() -> player2.startBattle(boss));
        }
    }
}

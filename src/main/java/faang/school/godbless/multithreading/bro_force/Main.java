package faang.school.godbless.multithreading.bro_force;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Enemy enemy = new Enemy();

        Player a = new Player("A", 3);
        Player b = new Player("B", 2);
        Player c = new Player("C", 4);

        Game game = new Game(List.of(a, b, c));

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(() -> {
            try {
                game.update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                a.fight(enemy, game);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                b.fight(enemy, game);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                c.fight(enemy, game);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }
}
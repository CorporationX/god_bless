package faang.school.godbless.multithreading.bro_force;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        List<Bro> bros = List.of(
                new Bro("Bro Lee", 7),
                new Bro("RamBro", 5)
        );

        Game game = new Game();
        bros.forEach(game::addBro);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < bros.size(); i++) {
            executor.submit(() -> {
                while (bros.get(0).getLives() > 0 && bros.get(1).getLives() > 0) {
                    boolean isGameOver = game.update();
                    System.out.println("Is anybody dead: " + isGameOver);
                }
            });
        }
        executor.shutdown();
    }
}

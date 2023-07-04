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

        ExecutorService executor = Executors.newFixedThreadPool(bros.size());

        executor.execute(() -> {
            while(bros.stream().allMatch(bro -> bro.getLives() > 0)) {
                boolean isGameOver = game.update();
                System.out.println("Is anybody dead: " + isGameOver);
            }
        });

        executor.shutdown();
    }
}

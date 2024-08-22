package faang.school.godbless.broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Process {

    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        Game game = new Game(new ArrayList<>(List.of(
                new Person("Biba"),
                new Person("Boba"),
                new Person("BratBoba"),
                new Person("BratBiba")
        )));

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        game.getGamers().forEach(g -> executorService.execute(() -> {
            while (game.getGamers().stream()
                    .mapToInt(Person::getLives)
                    .filter(i -> i == 0)
                    .findAny()
                    .isEmpty()) {
                game.update();
            }
        }));
        executorService.shutdown();
    }
}

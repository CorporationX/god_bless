package faang.school.godbless.multithreading.broforce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int NUM_THREAD = 3;

    public static void main(String[] args) {
        Game game = new Game(new ArrayList<>(List.of(
                new Player("Гендальф Серый", 8),
                new Player("Гендальф Белый", 10),
                new Player("Саша Белый", 9)
        )));
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);
        for (int i = 0; i < NUM_THREAD; i++) {
            executor.execute(game::update);
        }
        executor.shutdown();
    }

}

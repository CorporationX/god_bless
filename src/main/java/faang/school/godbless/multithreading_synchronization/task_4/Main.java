package faang.school.godbless.multithreading_synchronization.task_4;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        final Game game = new Game();
        final List<Bro> bros = getBros();
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        bros.forEach(game::addBro);
        bros.forEach(bro -> executor.submit(() -> game.update(bro)));
        executor.shutdown();
    }

    private static List<Bro> getBros() {
        return List.of(
                new Bro("Kostya", 10),
                new Bro("David", 7),
                new Bro("Alex", 5)
        );
    }
}

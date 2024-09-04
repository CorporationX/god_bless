package faang.school.godbless.computer.game.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYERS = 3;
    private static final int NUMBER_OF_THREADS = 4;
    private static final int TIME_FOR_GAME_IN_SECONDS = 4;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        executorService.execute(new Player("Bilbo", boss));
        executorService.execute(new Player("Frodo", boss));
        executorService.execute(new Player("Pippin", boss));
        executorService.execute(new Player("Merry", boss));
        executorService.execute(new Player("Gimli", boss));
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(TIME_FOR_GAME_IN_SECONDS , TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException exception) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}

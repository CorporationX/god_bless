package the_tournament_at_kings_landing;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int COUNT_THREAD = 2;
    private static ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    /**
     * This is the main method of the application.
     * It creates two knights with three trials each, and then runs them in parallel.
     * Each trial is a separate thread, and the main method waits for all the threads to finish.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Knight firstKnight = new Knight("Олег львиное сердце");
        List.of(
                new Trial("Олег львиное сердце", "Бой на мечах"),
                new Trial("Олег львиное сердце", "Фихтование"),
                new Trial("Олег львиное сердце", "Стрельба из лука")
        ).forEach(firstKnight::addTrial);

        Knight secondKnight = new Knight("Алеша Попович");
        List.of(
                new Trial("Алеша Попович", "Бой на кулаках"),
                new Trial("Алеша Попович", "Избиение воды в бочке"),
                new Trial("Алеша Попович", "Бой на палечах")
        ).forEach(secondKnight::addTrial);

        executorService.submit(firstKnight::startTrials);
        executorService.submit(secondKnight::startTrials);

        executorService.shutdown();
    }
}

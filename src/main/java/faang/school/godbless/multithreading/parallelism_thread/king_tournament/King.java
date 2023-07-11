package faang.school.godbless.multithreading.parallelism_thread.king_tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Aragon");
        Knight knight2 = new Knight("Frodo");

        knight1.addTrial(new Trial(knight1.getName(), "Помыть посуду", 4000L));
        knight1.addTrial(new Trial(knight1.getName(), "Постирать белье", 6000L));
        knight2.addTrial(new Trial(knight2.getName(), "Погладить рубашки", 2000L));
        knight2.addTrial(new Trial(knight2.getName(), "Вымыть полы", 30000L));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(knight1);
        executor.submit(knight2);

        executor.shutdown();

    }
}

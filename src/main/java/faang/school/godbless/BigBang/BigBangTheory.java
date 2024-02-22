package faang.school.godbless.BigBang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    final static int THREADS = 4;
    public static void main(String... args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        Task sheldonTask = new Task("Sheldon", "Theory preparation");
        Task leonardTask = new Task("Leonard", "Experiment modeling");
        Task hovardTask = new Task("Hovard", "Instrument construction");
        Task radzheshTask = new Task("Radzhesh", "Data analysis");
        executorService.execute(sheldonTask);
        executorService.execute(leonardTask);
        executorService.execute(hovardTask);
        executorService.execute(radzheshTask);
        executorService.shutdown();
        if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.err.println("Threads didn't finish in 10 seconds!");
        } else {
            System.out.println("All tasks are done!");
        }


}
}

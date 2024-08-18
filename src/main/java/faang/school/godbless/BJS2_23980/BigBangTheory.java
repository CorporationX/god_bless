package faang.school.godbless.BJS2_23980;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        var sheldonTask = new Task("Sheldon", "Theory preparation");
        var leonardTask = new Task("Leonard", "Experiment modeling");
        var govardTask = new Task("Govard", "Instruments development");
        var radjeshTask = new Task("Radjesh", "Data analysis");

        executorService.execute(sheldonTask::run);
        executorService.execute(leonardTask::run);
        executorService.execute(govardTask::run);
        executorService.execute(radjeshTask::run);

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All tasks were done");
    }
}

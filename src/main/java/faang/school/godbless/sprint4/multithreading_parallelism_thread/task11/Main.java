package faang.school.godbless.sprint4.multithreading_parallelism_thread.task11;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(30_000);
            executor.schedule(house::collectFood,0, TimeUnit.SECONDS);
            Thread.sleep(1000);
        }
        executor.shutdown();
        while (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)){}

        System.out.println("Еда в доме собрана!");
    }
}

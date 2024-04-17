package faang.school.godbless.bigbang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new Task("Sheldon", "Theoretical preparing"));
        service.submit(new Task("Leonard", "Experiment modeling"));
        service.submit(new Task("Howard", "Instruments development"));
        service.submit(new Task("Rajesh", "Data analysis"));

        service.shutdown();
        try {
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("All tasks are done");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

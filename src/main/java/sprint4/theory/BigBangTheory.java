package sprint4.theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int NUMBER_THREAD = 4;
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_THREAD);
        Task taskOne = new Task("Sheldon", "theory preparation");
        Task taskTwo = new Task("Leonard", "modeling the experiment");
        Task taskThree = new Task("Howard", "instrument development");
        Task taskFour = new Task("Rajesh", "data analysis");

        service.execute(taskOne);
        service.execute(taskTwo);
        service.execute(taskThree);
        service.execute(taskFour);

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
            service.shutdownNow();
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
    }
}

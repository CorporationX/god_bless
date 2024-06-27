package TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class WeasleyFamily {

    public static void main(String[] args) throws InterruptedException {
        String[] chores = new String[]{"Wash the floors", "To wash the dishes", "Do the laundry", "Cook dinner",};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("All chores completed");
    }
}

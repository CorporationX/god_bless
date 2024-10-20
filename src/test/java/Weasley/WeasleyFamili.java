package Weasley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamili {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        String[] chors = {"wash the dishes", "sweep the floor", "cook dinner"};
        for (String task : chors) {
            Chor chor = new Chor(task);
            service.execute(chor);
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(6, TimeUnit.SECONDS)) {
                System.out.println("the task did not complete within the specified time");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }

}

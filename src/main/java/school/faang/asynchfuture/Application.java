package school.faang.asynchfuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        MasterCardService service = new MasterCardService(executor);
        service.doAll();

        executor.shutdown();
    }
}

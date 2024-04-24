package AsynchronyAndFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        MasterCardService masterCardService = new MasterCardService();

        masterCardService.doAll(executorService);
    }
}

package school.faang.bjs2_92575;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            masterCardService.doAll(executor);
        } finally {
            executor.shutdown();
        }
    }
}

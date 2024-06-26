package faang.school.godbless.asynchrony_concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MasterCardService masterCardService = new MasterCardService();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        masterCardService.doAll(executor);

        executor.shutdown();
    }
}

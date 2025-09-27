package school.faang.bjs2_92575;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        masterCardService.doAll(executor);
    }
}

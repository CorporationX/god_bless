package faang.school.godbless.future;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMS_THREAD = 10;
    private ExecutorService executor = Executors.newFixedThreadPool(NUMS_THREAD);

    public static void main(String[] args) {
        Main mainThread = new Main();
        mainThread.doAll();

    }

    @SneakyThrows
    private void doAll() {
        MasterCardService service = new MasterCardService();
        Future<Integer> future = executor.submit(() -> service.collectPayment());
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> service.sendAnalytics(), executor);
        System.out.println(future.get(1, TimeUnit.MINUTES));
        System.out.println(completableFuture.get(1, TimeUnit.MINUTES));
        executor.shutdown();
    }
}

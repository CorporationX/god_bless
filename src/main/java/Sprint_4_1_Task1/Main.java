package Sprint_4_1_Task1;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    @SneakyThrows
    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);
        System.out.println(future2.join());
        System.out.println(future.get());

        executor.shutdown();
        System.out.println("Done!");
    }
    public static void main(String[] args) {
        doAll();
    }
}

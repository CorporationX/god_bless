package faang.school.godbless.sprint_3.multithreading_future.async_and_fututre;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        MasterCardService cardService = new MasterCardService();
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> first = service.submit(cardService::collectPayment);
        service.shutdown();
        CompletableFuture<Integer> second = CompletableFuture.supplyAsync(cardService::sendAnalytics);
        int firstValue = second.join();
        System.out.println(firstValue);
        try {
            int secondValue = first.get();
            System.out.println(secondValue);
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }
    }
}

package faang.school.godbless.BJS2_24616;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static int collectPayment(){
        try {
            Thread.sleep(10_000);
            log.info("send analytics is done after 10 sec");
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics(){
        try {
            Thread.sleep(1_000);
            log.info("send analytics is done after 1 sec");
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static   int doAll() throws ExecutionException, InterruptedException {
        Future<Integer> future = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);
        return completableFuture.join() + future.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(MasterCardService.doAll());
        executorService.shutdown();
    }
}

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCard {
    public static void doAll(MasterCardService masterCardService) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        System.out.println(future2.join());
        System.out.println(future.get());

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Программа выполнена");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        doAll(masterCardService);
    }
}

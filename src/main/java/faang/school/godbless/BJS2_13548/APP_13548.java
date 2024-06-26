package faang.school.godbless.BJS2_13548;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class APP_13548 {
    public static final Integer QUANTITY_OF_NUMS = 1000;
    public static List<SquareRequest> squareRequests = new ArrayList<>();
    public static ResultConsumer resultConsumer;

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer consumer) throws ExecutionException, InterruptedException, TimeoutException {
        List<CompletableFuture<Void>> resultFuture = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(requests.size());

        for (SquareRequest request : requests) {
            resultFuture.add(CompletableFuture.runAsync(() -> request.longTimeSquare(consumer), service));
        }
        CompletableFuture<Void> completedFutures = CompletableFuture.allOf(resultFuture.toArray(new CompletableFuture[0]));
        completedFutures.join();
        service.shutdown();
        return consumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        for (int i = 0; i <= QUANTITY_OF_NUMS; i++) {
            squareRequests.add(new SquareRequest((long) i));
        }
        resultConsumer = new ResultConsumer((long) 0);
        try {
            System.out.println("The result is " + fanOutFanIn(squareRequests, resultConsumer));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException | TimeoutException e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

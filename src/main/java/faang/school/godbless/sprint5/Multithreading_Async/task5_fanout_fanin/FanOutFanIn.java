package faang.school.godbless.sprint5.Multithreading_Async.task5_fanout_fanin;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FanOutFanIn {

    @SneakyThrows
    public Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        for (SquareRequest request : requests) {
            CompletableFuture<Integer> resultConsumerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                request.longTimeSquare(resultConsumer);
                return 1;
            });
            completableFutures.add(resultConsumerCompletableFuture);
        }
        CompletableFuture[] squareRequestsArray = new CompletableFuture[completableFutures.size()];
        completableFutures.toArray(squareRequestsArray);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(squareRequestsArray);

        voidCompletableFuture.join();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }


    public void launch() {
        List<SquareRequest> squareRequests = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            squareRequests.add(new SquareRequest(i));
        }
        Long aLong = fanOutFanIn(squareRequests, new ResultConsumer(0L));
        System.out.println(aLong);
    }

    public static void main(String[] args) {
        FanOutFanIn fanOutFanIn = new FanOutFanIn();
        fanOutFanIn.launch();
    }
}

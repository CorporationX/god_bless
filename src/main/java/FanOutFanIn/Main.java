package FanOutFanIn;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int calculatedNumber = 10;
        CompletableFuture<Void> future = launch(calculatedNumber);
        future.join();
    }

    public static CompletableFuture<Long> fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture<Void> allTask = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        return allTask.thenApply(result -> resultConsumer.getSumOfSquaredNumbers().get());
    }

    public static CompletableFuture<Void> launch(int amountSquareRequest) {
        List<SquareRequest> listSquareRequest = LongStream
                .range(1, ++amountSquareRequest)
                .mapToObj(SquareRequest::new)
                .toList();

        return fanOutFanIn(listSquareRequest, new ResultConsumer(0L))
                .thenAccept(System.out::println);
    }
}
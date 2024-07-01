package FanOutFanIn;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int calculatedNumber = 1000;
        launch(calculatedNumber);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture<Void> allTask = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTask.join();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch(int amountSquareRequest) {
        List<SquareRequest> listSquareRequest = LongStream
                .range(1, ++amountSquareRequest)
                .mapToObj(SquareRequest::new)
                .toList();

        System.out.println(fanOutFanIn(listSquareRequest, new ResultConsumer(0L)));
    }
}
package faang.school.godbless.BJS2_25024;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.LongStream;


public class FanOutFanIn {
    public static void main(String[] args) {
        launch();
    }

    private static void fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        List<CompletableFuture<Void>> squareResults = requests.stream()
                .map(request -> createTask(request, resultConsumer))
                .map(CompletableFuture::supplyAsync)
                .toList();

        CompletableFuture.allOf(squareResults.toArray(new CompletableFuture[0])).join();
    }

    private static Supplier<Void> createTask(SquareRequest request, ResultConsumer resultConsumer) {
        return () -> request.longTimeSquare(resultConsumer);
    }

    private static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .mapToObj(SquareRequest::new)
                .toList();
        fanOutFanIn(requests, resultConsumer);
        System.out.println("Sum = " + resultConsumer.getSum());
    }


}
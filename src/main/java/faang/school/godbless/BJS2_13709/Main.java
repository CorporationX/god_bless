package faang.school.godbless.BJS2_13709;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    private static final int COUNT_SQUARE_REQUESTS = 5;

    public static void main(String[] args) {
        List<SquareRequest> squareRequestList = launch(COUNT_SQUARE_REQUESTS);
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(squareRequestList, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        try (ExecutorService service = Executors.newFixedThreadPool(requests.size())) {
            for (SquareRequest squareRequest : requests) {
                futureList.add(CompletableFuture.runAsync(
                        () -> squareRequest.longTimeSquare(resultConsumer), service));
            }

            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        }

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static List<SquareRequest> launch(int count) {
        return LongStream.rangeClosed(1, count)
                .parallel()
                .mapToObj(SquareRequest::new)
                .toList();
    }

}

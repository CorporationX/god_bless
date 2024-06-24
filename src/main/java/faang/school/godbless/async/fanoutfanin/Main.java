package faang.school.godbless.async.fanoutfanin;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {

    private static final int N_INCLUSIVE = 1000;

    public static void main(String[] args) {
        List<SquareRequest> squareRequests = LongStream.rangeClosed(1, N_INCLUSIVE)
                .boxed()
                .map(SquareRequest::new)
                .toList();

        Long result = fanOutFanIn(squareRequests, new ResultConsumer(0L));
        System.out.println(result);
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        Set<CompletableFuture<Void>> cfsSet = requests.stream()
                .map(squareRequest -> CompletableFuture.runAsync(
                                () -> squareRequest.longTimeSquare(resultConsumer), executorService))
                .collect(Collectors.toSet());

        cfsSet.forEach(CompletableFuture::join);
        executorService.shutdown();
        return resultConsumer.getFinal();
    }
}

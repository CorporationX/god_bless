package faang.school.godbless.bjs2_25136;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int NUMBER_OF_ELEMENTS = 1000;
    private static final long INIT_VALUE = 0L;

    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        List<SquareRequest> requests = initRequests();
        ResultConsumer resultConsumer = new ResultConsumer(INIT_VALUE);

        log.info("Squares sum: {}", fanOutFanIn(requests, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request ->
                        CompletableFuture.runAsync(() ->
                                request.longTimeSquare(resultConsumer), executorService
                        )
                )
                .toList();

        CompletableFuture
                .allOf(futures.toArray(CompletableFuture[]::new))
                .join();

        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static List<SquareRequest> initRequests() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= NUMBER_OF_ELEMENTS; i++) {
            requests.add(new SquareRequest(i));
        }
        return requests;
    }
}

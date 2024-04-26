package faang.school.godbless.fanoutfanin;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    private static final int N_ELEMENTS = 1000;
    public static void main(String[] args) {
        launch(N_ELEMENTS);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (SquareRequest request : requests) {
            futureList.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService));
        }
        executorService.shutdown();

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();

        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static void launch(int elements) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();

        for (int i = 0; i < elements; i++) {
            requests.add(new SquareRequest(i + 1L));
        }
        log.info("Result: {}", fanOutFanIn(requests, resultConsumer));
        log.info("expected result: 333833500");
    }
}

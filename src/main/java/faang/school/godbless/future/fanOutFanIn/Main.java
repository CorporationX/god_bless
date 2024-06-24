package faang.school.godbless.future.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    private static final int NUMBER_OF_REQUESTS = 1000;

    public static void main(String[] args) {

        System.out.println(launch());
    }

    public static Long launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        LongStream.rangeClosed(1, NUMBER_OF_REQUESTS).forEach(number -> requests.add(new SquareRequest(number)));
        return fanOutFanIn(requests, resultConsumer);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size()); //насколько рационально так делать?
        // Возможно, тут проще через CachedThreadPool;

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        requests.forEach(squareRequest ->
                futures.add(CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executorService)));

        futures.forEach(CompletableFuture::join);

        executorService.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}

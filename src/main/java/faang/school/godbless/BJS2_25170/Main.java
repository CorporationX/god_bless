package faang.school.godbless.BJS2_25170;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    private static final long SQUARE_REQUEST_SIZE = 1000;

    public static void main(String[] args) {
        launch();
    }

    static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        LongStream.rangeClosed(1, SQUARE_REQUEST_SIZE)
                .forEach(index -> requests.add(new SquareRequest(index)));

        ResultConsumer consumer = new ResultConsumer(0L);
        long result = fanOutFanIn(requests, consumer);
        System.out.println("Result is " + result);
    }

    static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        ExecutorService service = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), service))
                .toList();

        CompletableFuture.allOf(futures.get(0)).join();

        service.shutdown();
        return resultConsumer.getResult();
    }
}

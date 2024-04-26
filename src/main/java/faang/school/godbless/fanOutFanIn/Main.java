package faang.school.godbless.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        requests.forEach(squareRequest ->
                CompletableFuture.allOf(CompletableFuture.runAsync(() ->
                                squareRequest.longTimeSquare(resultConsumer)))
                        .join()
        );
        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        for (long i = 1; i < 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        System.out.println("Result: " + fanOutFanIn(requests, resultConsumer));
    }
}

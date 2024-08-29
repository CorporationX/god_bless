package faang.school.godbless.BJS2_25062;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FanOutFanIn {
    public static void main(String[] args) {
       launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList()
                .forEach(CompletableFuture::join);

        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }

    public static void launch() {
        var resultConsumer = new ResultConsumer(0L);
        var requests = new ArrayList<SquareRequest>();

        for (int i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }

        var sum = fanOutFanIn(requests, resultConsumer);
        System.out.printf("Sum of Square numbers: %d\n", sum);
    }
}
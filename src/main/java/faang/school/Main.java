package faang.school;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        List<SquareRequest> requests = Stream
                .iterate(1, i -> i + 1)
                .limit(1000)
                .map(i -> new SquareRequest((long) i))
                .toList();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long sumOfSquaredNumbers = fanOutFanIn(requests, resultConsumer);
        System.out.println(sumOfSquaredNumbers);
    }


    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        var futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        futures.forEach(CompletableFuture::join);
        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }
}

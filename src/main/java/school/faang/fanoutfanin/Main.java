package school.faang.fanoutfanin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int COUNT_REQUEST = 1000;

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (SquareRequest squareRequest : requests) {
            futures.add(CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer)));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return resultConsumer.getSum();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();

        for (long i = 0; i <= COUNT_REQUEST; i++) {
            requests.add(new SquareRequest(i));
        }

        System.out.println("Сумма квадратов чисел от 1 до " + COUNT_REQUEST + ": " + fanOutFanIn(requests, resultConsumer));
    }

    public static void main(String[] args) {
        launch();
    }
}
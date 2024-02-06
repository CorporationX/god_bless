package fanOutFanIn_1242;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static final int NUMBERS = 1000;

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        List<CompletableFuture<Long>> results = requests.stream()
                .map((request)-> CompletableFuture.supplyAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        results.stream()
                .forEach(CompletableFuture::join);

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();

        for (int i = 1; i <= NUMBERS; i++) {
            requests.add(new SquareRequest((long) i));
        }
        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));
    }
}
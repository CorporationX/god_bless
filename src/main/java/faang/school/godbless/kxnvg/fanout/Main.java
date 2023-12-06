package faang.school.godbless.kxnvg.fanout;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        launch();
    }

    @SneakyThrows
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        CompletableFuture<Void>[] futures = new CompletableFuture[requests.size()];

        for (int i = 0; i < requests.size(); i++) {
            final int j = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> requests.get(j).longTimeSquare(resultConsumer));
            futures[i] = future;
        }
        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(futures);
        resultFuture.get();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            requests.add(new SquareRequest((long) i));
        }

        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));
    }
}

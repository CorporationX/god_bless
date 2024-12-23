package school.faang.sprint_4.task_50235;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static final int POW_START_NUMBER = 1;
    public static final int POW_END_NUMBER = 1000;

    public static void main(String[] args) {
        launch();
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        if (requests.isEmpty() || resultConsumer == null) {
            throw new IllegalArgumentException("Неверные входные параметры");
        }
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();
        return resultConsumer.getSum();
    }

    private static void launch() {
        List<SquareRequest> requests = IntStream.rangeClosed(POW_START_NUMBER, POW_END_NUMBER)
                .mapToObj(index -> new SquareRequest((long) index))
                .toList();

        ResultConsumer consumer = new ResultConsumer(0L);
        Long sumResult = fanOutFanIn(requests, consumer);
        System.out.printf("Сумма квадратов от %s до %s будет %s", POW_START_NUMBER, POW_END_NUMBER, sumResult);
    }
}

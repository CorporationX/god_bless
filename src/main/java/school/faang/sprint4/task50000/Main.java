package school.faang.sprint4.task50000;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int FROM_INTEGER = 1;
    private static final int TO_INTEGER = 1000;

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        log.info("Запуск подсчета суммы квадратов чисел от {} до {}", FROM_INTEGER, TO_INTEGER);
        ResultConsumer result = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = FROM_INTEGER; i <= TO_INTEGER; i++) {
            requests.add(new SquareRequest((long) i));
        }

        long sum = fanOutFanIn(requests, result);
        log.info("Сумма квадратов чисел от {} до {}: {}", FROM_INTEGER, TO_INTEGER, sum);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> results = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();
        CompletableFuture.allOf(results.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSum();
    }
}

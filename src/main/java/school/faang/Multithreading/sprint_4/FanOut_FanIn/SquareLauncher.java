package school.faang.Multithreading.sprint_4.FanOut_FanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SquareLauncher {
    public static final Long FIRST_NUM = 1L;
    public static final Long LAST_NUM = 1000L;
    public static final List<SquareRequest> request = new ArrayList<>();

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        for (long i = FIRST_NUM; i <= LAST_NUM; i++) {
            request.add(new SquareRequest(i));
        }

        System.out.printf("Сумма квадратов чисел от 1 до 1000: %d", fanOutFanIn(request, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return resultConsumer.getSum();
    }
}

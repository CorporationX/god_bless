package school.faang.sprint_4.task_43572;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int NUMBERS = 1_000;

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 0; i < NUMBERS; i++) {
            requests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        System.out.println("Сумма квадратов чисел от 1 до 1000: " + fanOutFanIn(requests, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return resultConsumer.getSum();
    }
}
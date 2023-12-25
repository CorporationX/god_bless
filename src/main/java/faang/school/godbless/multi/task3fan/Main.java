package faang.school.godbless.multi.task3fan;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<CompletableFuture<Void>> listSquareFuture = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toList();

        CompletableFuture.allOf(listSquareFuture.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();

        return resultConsumer.add(0L);
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .mapToObj(SquareRequest::new)
                .collect(Collectors.toList());

        Long sum = fanOutFanIn(requests, resultConsumer);

        System.out.println("Сумма квадратов чисел от 1 до 1000: " + sum);
    }
}

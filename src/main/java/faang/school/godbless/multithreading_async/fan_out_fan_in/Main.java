package faang.school.godbless.multithreading_async.fan_out_fan_in;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    static void launch() {
        List<SquareRequest> list = LongStream.rangeClosed(1, 1000)
                .mapToObj(num -> new SquareRequest(num)).toList();

        System.out.println("Запуск: " + fanOutFanIn(list, new ResultConsumer(0l)));

    }


    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> completableFutures =
                requests.stream().map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor)).toList();

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();

    }
}

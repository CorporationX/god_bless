package faang.school.godbless.multithreading_2.fanoutfanin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        launch(1, 1000);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> completableFuturies = new ArrayList<>();
        for (SquareRequest request : requests) {
            completableFuturies.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor));
        }

        completableFuturies.forEach(CompletableFuture::join);
        executor.shutdown();
        return  resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch(int leftBorder, int rightBorder) {
        List<SquareRequest> requests = Stream.iterate(leftBorder, n -> n + 1)
                .limit(rightBorder - leftBorder + 1)
                .map(n -> new SquareRequest((Long.valueOf(n))))
                .toList();

        Long result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println("Результат сложения квадратов от " + leftBorder + " до " + rightBorder + ":");
        System.out.println(result);
    }

}

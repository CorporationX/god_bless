package school.BJS2_38021;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        launch();
    }


    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService service = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (SquareRequest request : requests) {
            futures.add(CompletableFuture.runAsync(() -> {
                request.longTimeSquare(resultConsumer);
            }, service));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        service.shutdown();
        return resultConsumer.getSum();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer((long) 0);
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }
        long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("Сумма квадратов чисел от 1 до 1000: " + result);
    }

}

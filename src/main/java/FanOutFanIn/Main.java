package FanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        List<SquareRequest> requestList = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        for (int i = 1; i <= 1000; i++) {
            requestList.add(new SquareRequest((long) i));
        }
        fanOutFanIn(requestList, resultConsumer);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        // запустить n CompletableFuture задач
        List<CompletableFuture> futureList = new ArrayList<>();
        for (SquareRequest request : requests) {
            CompletableFuture<ResultConsumer> completableFuture = CompletableFuture.supplyAsync(() -> {
                request.longTimeSquare(resultConsumer);
                return resultConsumer;
            });
            futureList.add(completableFuture);
        }
        // дождаться их выполнения
        for (CompletableFuture completableFuture : futureList) {
            completableFuture.join();
        }

        //вернуть результат у resultConsumer
        System.out.println(resultConsumer.getSumOfSquaredNumbers());
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}

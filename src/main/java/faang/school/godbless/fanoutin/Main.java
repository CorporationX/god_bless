package faang.school.godbless.fanoutin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        launch();
    }

    public static void launch() throws InterruptedException {
        ResultConsumer fanInresult = new ResultConsumer(0L);
        Long fanOut = fanOutFanIn(getRequest(), fanInresult);
        System.out.printf("SumSquare = " + fanOut + "%n");
    }

    private static List<SquareRequest> getRequest() {
        List<SquareRequest> squareRequestList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            squareRequestList.add(new SquareRequest((long) i));
        }
        return squareRequestList;
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) throws InterruptedException {
        ExecutorService newExecutor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> taskList = new ArrayList<>();

        requests.forEach(request -> taskList.add((CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), newExecutor))));
        CompletableFuture.allOf(taskList.toArray(CompletableFuture[]::new)).join();

        newExecutor.shutdown();
        if (newExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Все потоки были успешно выполнены");
        } else {
            System.out.println("Не все потоки были выполнены за отведенное время");
        }
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
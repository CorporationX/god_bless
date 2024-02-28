package faang.school.godbless.fan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture futureResult = CompletableFuture.runAsync(() ->{
            requests.forEach(request -> request.longTimeSquare(resultConsumer));
        }, executorService);

        try {
            futureResult.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }
    public static List<SquareRequest> launch(){
        List<SquareRequest> list = new ArrayList<>();
        for (long i =  1; i <= 10; i++){
            list.add(new SquareRequest(i));
        }
        return list;
    }

    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(launch(),  resultConsumer));
    }
}

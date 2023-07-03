package faang.school.godbless.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        for(var request : requests){
            CompletableFuture<Void> result = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer));
            try {
                result.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void main(String[] args) {
        List<SquareRequest> requestList = new ArrayList<>();
        requestList.add(new SquareRequest(100L));
        requestList.add(new SquareRequest(55L));
        requestList.add(new SquareRequest(15646L));
        requestList.add(new SquareRequest(7879464L));
        ResultConsumer result = new ResultConsumer(0L);

        System.out.println("Результат вычислений - " + fanOutFanIn(requestList, result));
    }
}

package faang.school.godbless.ThirdSprint.BJS2_25199;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        for(int i = 1; i <= 100; i++){
            requests.add(new SquareRequest((long)i));
        }

        System.out.println(fanOutFanIn(requests, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService service = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        requests.stream()
                .forEach(r -> futureList.add(CompletableFuture.runAsync(() -> r.longTimeSquare(resultConsumer))));
        futureList.stream().forEach(CompletableFuture::join);

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}

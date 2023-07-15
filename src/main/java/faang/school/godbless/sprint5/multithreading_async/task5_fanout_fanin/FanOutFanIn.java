package faang.school.godbless.sprint5.multithreading_async.task5_fanout_fanin;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FanOutFanIn {

    @SneakyThrows
    public Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> completableFutures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).join();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }


    public void launch() {
        List<SquareRequest> squareRequests = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            squareRequests.add(new SquareRequest(i));
        }
        Long aLong = fanOutFanIn(squareRequests, new ResultConsumer(0L));
        System.out.println(aLong);
    }

    public static void main(String[] args) {
        FanOutFanIn fanOutFanIn = new FanOutFanIn();
        fanOutFanIn.launch();
    }
}

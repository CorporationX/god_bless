package faang.school.godbless.fanout_fanin;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Calculator {
    public static Long fanOutFanIn(@NonNull List<SquareRequest> requests,
                                   @NonNull ResultConsumer resultConsumer,
                                   @NonNull ExecutorService executorService) {
        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();

        requests.forEach((request) ->
                completableFutureList.add(
                        CompletableFuture.runAsync(
                                () -> request.longTimeSquare(resultConsumer),
                                executorService)));

        completableFutureList.forEach(CompletableFuture::join);

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}

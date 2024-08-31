package faang.school.godbless.task25203;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<CompletableFuture<Integer>> future = requests.stream()
                .map(request -> CompletableFuture.supplyAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {

    }
}

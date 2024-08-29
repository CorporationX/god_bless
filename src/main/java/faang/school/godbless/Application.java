package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j

public class Application {
    public static void main(String[] args) {
        val resultConsumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(lunch(), resultConsumer));
    }

    public static List<SquareRequest> lunch() {
        return LongStream.range(0, 1000).mapToObj(i -> new SquareRequest(1)).toList();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Long>> list = requests.stream().map(request -> {
                    return CompletableFuture.supplyAsync(() -> {
                        return request.longTimeSquare(resultConsumer);
                    }, executorService);
                }
        ).toList();


        CompletableFuture.allOf(list.toArray(CompletableFuture[]::new)).join();
        log.info(" ffff " + resultConsumer.getCopy());
        executorService.shutdown();
        return resultConsumer.getCopy();
    }

}
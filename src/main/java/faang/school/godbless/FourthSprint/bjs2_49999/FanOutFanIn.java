package faang.school.godbless.FourthSprint.bjs2_49999;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class FanOutFanIn {
    final static Logger logger = LoggerFactory.getLogger(FanOutFanIn.class.getName());

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService execotor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<CompletableFuture<Void>> requestFutures = requests.stream().map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), execotor)).collect(Collectors.toList());

        CompletableFuture.allOf(requestFutures.toArray(new CompletableFuture[0])).join();
        Long result = resultConsumer.getSum();
        execotor.shutdown();

        return result;
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>(1000);
        for (long i = 1L; i <= 100; i++) {
            requests.add(new SquareRequest(i));
        }
        ResultConsumer consumer = new ResultConsumer(0L);

        logger.info("fanOutFanIn method result " + fanOutFanIn(requests, consumer).toString());
    }
}

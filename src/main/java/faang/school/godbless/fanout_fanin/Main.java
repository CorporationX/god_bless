package faang.school.godbless.fanout_fanin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    private static final int UPPER_BOUND = 1001;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        launch(executorService);

        executorService.shutdown();
    }

    private static void launch(ExecutorService executorService) {
        List<SquareRequest> squareRequestList = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        LongStream.range(1, UPPER_BOUND).forEach((number) -> squareRequestList.add(new SquareRequest(number)));

        long result = Calculator.fanOutFanIn(squareRequestList, resultConsumer, executorService);
        System.out.println(result);
    }
}

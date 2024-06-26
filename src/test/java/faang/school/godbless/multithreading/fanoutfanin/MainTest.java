package faang.school.godbless.multithreading.fanoutfanin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

class MainTest {
    private static final long START_PERIOD = 1;
    private static final long END_NUMBER = 10;

    private static void print(Long result, String format, long endTime, long startTime) {
        System.out.printf("Sum of digits from %d till %d is %d.\n", START_PERIOD, END_NUMBER, result);
        System.out.printf(format, (endTime - startTime));
        System.out.println("=====================================");
    }

    private static List<SquareRequest> getSquareRequests() {
        List<SquareRequest> squareRequestList = new ArrayList<>();
        LongStream.rangeClosed(START_PERIOD, END_NUMBER)
                .forEach(i -> squareRequestList.add(new SquareRequest(i)));
        return squareRequestList;
    }

    @Test
    @DisplayName("Test fanOutFanIn without using ExecutorService")
    void fanOutFanInWithoutExecutorService() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        var squareRequestList = getSquareRequests();

        long startTime = System.currentTimeMillis();
        var result = Main.fanOutFanInWithoutExecutorService(squareRequestList, resultConsumer);

        long endTime = System.currentTimeMillis();
        print(result, "Time taken for fanOutFanIn without ExecutorService: %d milliseconds.\n", endTime, startTime);
    }

    @Test
    @DisplayName("Test fanOutFanIn with using ExecutorService")
    void fanOutFanIn() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        var squareRequestList = getSquareRequests();

        long startTime = System.currentTimeMillis();
        var result = Main.fanOutFanIn(squareRequestList, resultConsumer);

        long endTime = System.currentTimeMillis();
        print(result, "Time taken for fanOutFanIn with ExecutorService: %d milliseconds.\n", endTime, startTime);
    }
}
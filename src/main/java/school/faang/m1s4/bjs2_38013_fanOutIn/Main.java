package school.faang.m1s4.bjs2_38013_fanOutIn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final long limitBound = 1_000L;

        AsyncCalculator calcTreads5 = new AsyncCalculator(100);
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();

        for (long i = 1; i <= limitBound; i++) {
            requests.add(new SquareRequest(i));
        }

        long startTime = System.currentTimeMillis();
        System.out.printf("Sum of squares between 1 and %d: %d%n",
                limitBound, calcTreads5.fanOutFanIn(requests, resultConsumer));
        System.out.println("Time passed (ms): " + (System.currentTimeMillis() - startTime));

    }
}

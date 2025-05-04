package school.faang.pi;

import java.util.concurrent.ExecutionException;

public class Main {
    private static final int NUM_OF_POINTS = 10000000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PointService.calculate(NUM_OF_POINTS);
    }
}

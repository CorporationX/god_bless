package faang.school.godbless.completablefuture.pi;

import java.util.concurrent.ThreadLocalRandom;

public class CalculatePIApp {

    private static final double R = 1.0;
    private static final long pointsNumber = 10000000000L;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println("Started calculation...");
        double pi = calculatePi();

        long calculationInSeconds = (System.currentTimeMillis() - startMillis) / 1000;
        System.out.println("calculationInSeconds = " + calculationInSeconds);
        System.out.println("pi = " + pi);
    }

    private static double calculatePi() {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        long inside = localRandom
                .ints(pointsNumber)
                .parallel()
                .mapToObj((i) -> new Point(localRandom.nextDouble(0, 1), localRandom.nextDouble(0, 1)))
                .filter(point -> Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= Math.pow(R, 2))
                .count();
        return 4.0 * inside / pointsNumber;
    }

}

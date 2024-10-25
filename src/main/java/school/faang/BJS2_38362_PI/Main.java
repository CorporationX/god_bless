package school.faang.BJS2_38362_PI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final double TEST_RADIUS = 1;
    private static final int TEST_POINTS_COUNT = 1_000;

    public static void main(String[] args) {
        PiEstimator piEstimator = new PiEstimator(TEST_RADIUS);
        log.info("{}", piEstimator.calculatePi(TEST_POINTS_COUNT));
    }
}

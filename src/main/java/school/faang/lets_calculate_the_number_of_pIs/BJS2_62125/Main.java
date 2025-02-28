package school.faang.lets_calculate_the_number_of_pIs.BJS2_62125;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int NUM_OF_POINTS = 1_000_000;

    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();
        log.info("Приближенное значение Пи: {}", piCalculator.calculatePi(NUM_OF_POINTS));
    }
}

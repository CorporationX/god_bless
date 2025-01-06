package school.faang.numberpi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int NUMBER_OF_POINTS = 9999999;

    public static void main(String[] args) {
        PiCalculator calculator = new PiCalculator();
        double pi = calculator.calculatePi(NUMBER_OF_POINTS);
        log.info("Estimated value of Pi: {}", pi);
    }
}

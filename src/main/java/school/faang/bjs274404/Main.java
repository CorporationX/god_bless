package school.faang.bjs274404;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int POINTS_COUNT = 1_000_000;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        log.info("Calculated Pi value is: {}", calculator.calculatePi(POINTS_COUNT));
    }
}

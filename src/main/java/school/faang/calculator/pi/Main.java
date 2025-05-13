package school.faang.calculator.pi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        PiCalculator calculator = new PiCalculator();

        try {
            int[] pointCounts = {1_000_000, 100_000_000};

            for (int count : pointCounts) {
                double pi = calculator.calculatePi(count);
                log.info("Points: {} | Pi = {}", count, pi);
            }
        } finally {
            calculator.shutdown();
        }
    }
}

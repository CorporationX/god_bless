package school.faang.task49885;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int COUNT_POINTS = 10000000;

    public static void main(String[] args) {
        FindingPi findingPi = new FindingPi();
        log.info("Число PI для {} точек равен: {}", COUNT_POINTS, findingPi.calculatePi(COUNT_POINTS));
    }
}

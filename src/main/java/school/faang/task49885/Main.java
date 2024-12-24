package school.faang.task49885;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int COUNT_POINTS = 10000000;

    public static void main(String[] args) {
        FindingPI findingPI = new FindingPI();
        log.info("Число PI для {} точек равен: {}", COUNT_POINTS, findingPI.calculatePI(COUNT_POINTS));
    }
}

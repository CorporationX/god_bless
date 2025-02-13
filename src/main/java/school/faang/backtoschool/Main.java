package school.faang.backtoschool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final double SIDE_A = 3;
    private static final double SIDE_B = 4;
    private static final double SIDE_C = 5;

    public static void main(String[] args) {
        try {
            TriangleAreaCalculator calculator = new TriangleAreaCalculator();
            log.info("Triangle area: {}", calculator.calculateTriangleArea(SIDE_A, SIDE_B, SIDE_C));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}

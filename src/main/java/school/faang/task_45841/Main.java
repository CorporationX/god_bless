package school.faang.task_45841;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        double area = calculator.calculateTriangleArea(5, 5, 5);

        log.info("Triangle area: {}", area);
    }
}

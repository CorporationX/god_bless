package school.faang.bjs2_71572;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        double area = TriangleAreaCalculator.calculateTriangleArea(3, 4, 5);
        log.info("Площадь треугольника: {}", area);
    }
}

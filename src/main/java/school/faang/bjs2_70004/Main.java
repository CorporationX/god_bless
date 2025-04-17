package school.faang.bjs2_70004;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        double area = TriangleAreaCalculator.calculateTriangleArea(3, 4, 5);
        log.info("Площадь треугольника: {}", area);
    }
}
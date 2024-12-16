package school.faang.sprint_2.task_bjs245884;

import java.util.function.Function;

public class TriangleAreaCalculator {

    private final Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    private final Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    private final Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    private final Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    private final Function<Double, Double> squareRoot = Math::sqrt;

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 4, 5);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (sideA >= add.apply(sideB).apply(sideC)
                || sideB >= add.apply(sideA).apply(sideC)
                || sideC >= add.apply(sideA).apply(sideB)
        ) {
            throw new IllegalArgumentException("Невозможно создать треугольник с указанными сторонами");
        }

        double aPlusB = add.apply(sideA).apply(sideB);
        double perimeter = add.apply(aPlusB).apply(sideC);
        double p = divide.apply(perimeter).apply(2.0);
        double pMinusA = subtract.apply(p).apply(sideA);
        double pMinusB = subtract.apply(p).apply(sideB);
        double pMinusC = subtract.apply(p).apply(sideC);
        double productPa = multiply.apply(p).apply(pMinusA);
        double productPab = multiply.apply(productPa).apply(pMinusB);
        double productPabc = multiply.apply(productPab).apply(pMinusC);
        return squareRoot.apply(productPabc);
    }
}

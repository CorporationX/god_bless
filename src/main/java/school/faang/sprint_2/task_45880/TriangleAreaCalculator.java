package school.faang.sprint_2.task_45880;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    // Метод для вычисления площади треугольника
    public Double calculateTriangleArea(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (add.apply(sideA).apply(sideB) <= sideC
                || add.apply(sideA).apply(sideC) <= sideB
                || add.apply(sideB).apply(sideC) <= sideA) {
            throw new IllegalArgumentException("Неправильные стороны треугольника");
        }
        Double sumAbc = add.apply(
                add.apply(sideA).apply(sideB)
        ).apply(sideC);
        Double semiPerimeter = divide.apply(sumAbc).apply(2.0);

        Double subtractPandA = subtract.apply(semiPerimeter).apply(sideA);
        Double subtractPandB = subtract.apply(semiPerimeter).apply(sideB);
        Double subtractPandC = subtract.apply(semiPerimeter).apply(sideC);

        Double multiplyOfSubtractPandAbc = multiply.apply(
                multiply.apply(subtractPandA).apply(subtractPandB)
        ).apply(subtractPandC);

        Double square = squareRoot.apply(multiply.apply(semiPerimeter).apply(multiplyOfSubtractPandAbc));

        return square;
    }

    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();

        try {
            double area = calculator.calculateTriangleArea(3, 4, 5);
            System.out.println("Площадь треугольника: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

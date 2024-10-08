package school.faang.area.triangle;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Длинны сторон не могут быть отрицательными или нулевыми");
        }
        if (a >= add.apply(b).apply(c) || b >= add.apply(a).apply(c) || c >= add.apply(b).apply(a)) {
            throw new IllegalArgumentException("Сумма длин двух сторон не может превышать длину третьей стороны");
        }

        double perimeter = add.apply(add.apply(a).apply(b)).apply(c);
        double semiPerimeter = divide.apply(perimeter).apply(2.0);
        double diffPerimeterAndA = subtract.apply(semiPerimeter).apply(a);
        double diffPerimeterAndB = subtract.apply(semiPerimeter).apply(b);
        double diffPerimeterAndC = subtract.apply(semiPerimeter).apply(c);
        double productOfDiffs = multiply.apply(multiply.apply(diffPerimeterAndA).apply(diffPerimeterAndB))
                .apply(diffPerimeterAndC);
        double productDiffsAndSemiPerimeter = multiply.apply(productOfDiffs).apply(semiPerimeter);
        return squareRoot.apply(productDiffsAndSemiPerimeter);
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

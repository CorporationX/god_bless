package school.faang.BJS2_34059_RememberTheSchool;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        validateTriangleSides(a, b, c);

        double perimeter = add.apply(add.apply(a).apply(b)).apply(c);
        double halfPerimeter = divide.apply(perimeter).apply(2.0);
        double halfPerimeterMinusA = subtract.apply(halfPerimeter).apply(a);
        double halfPerimeterMinusB = subtract.apply(halfPerimeter).apply(b);
        double halfPerimeterMinusC = subtract.apply(halfPerimeter).apply(c);
        double triangleAreaSquare =
                multiply.apply(halfPerimeter).apply(multiply.apply(multiply.apply(halfPerimeterMinusA).apply(halfPerimeterMinusB)).apply(halfPerimeterMinusC));
        return squareRoot.apply(triangleAreaSquare);
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

    private void validateTriangleSides(double firstSide, double secondSide, double thirdSide) {
        double firstPlusSecond = add.apply(firstSide).apply(secondSide);
        double firstPlusThird = add.apply(firstSide).apply(thirdSide);
        double secondPlusThird = add.apply(secondSide).apply(thirdSide);

        if (thirdSide > firstPlusSecond || secondSide > firstPlusThird || firstSide > secondPlusThird) {
            throw new IllegalArgumentException("A triangle with such sides can't exist!");
        }
    }
}

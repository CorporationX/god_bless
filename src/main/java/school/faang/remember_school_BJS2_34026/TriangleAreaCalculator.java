package school.faang.remember_school_BJS2_34026;

import java.util.function.Function;

public class TriangleAreaCalculator {
    Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    Function<Double, Double> squareRoot = (x) -> Math.sqrt(x);

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
         //Formula:  p= (a+b+c) / 2;   |  S = √ p * (p−a) * (p−b) * (p−c);

        if (c >= a + b || a >= b + c || b >= c + a)
            throw new IllegalArgumentException("One side of triangle should be smaller than sum of two others");
        double forDividingByHalf = 2.0;
        double sumAbc = add.apply(c).apply(add.apply(a).apply(b));
        double p = divide.apply(sumAbc).apply(forDividingByHalf);
        double pMinusA = subtract.apply(p).apply(a);
        double pMinusB = subtract.apply(p).apply(b);
        double pMinusC = subtract.apply(p).apply(c);
        double ValueToSquareRoot = multiply.apply(multiply.apply(multiply.apply(p).apply(pMinusA)).apply(pMinusB)).apply(pMinusC);
        return squareRoot.apply(ValueToSquareRoot);
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

package sprint3.lambda.school;

import java.util.function.Function;

public class School {
    private static final Function<Double, Function<Double, Double>> SUM = (x) -> y -> x + y;
    private static final Function<Double, Function<Double, Double>> MUL = (x) -> y -> x * y;
    private static final Function<Double, Function<Double, Double>> SUB = (x) -> y -> x - y;
    private static final Function<Double, Function<Double, Double>> DIV = (x) -> y -> x / y;
    private static final Function<Double, Double> SQRT = Math::sqrt;
    public static void main(String[] args) {
        School school = new School();
        System.out.println(school.triangleArea(5, 10 , 10));
        System.out.println(school.triangleArea(12, 12, 6));
    }

    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        double p = findPerimeter(a, b, c);

        double subA = SUB.apply(p).apply(a);
        double subB = SUB.apply(p).apply(a);
        double subC = SUB.apply(p).apply(a);

        return findArea(subA, subB, subC, p);
    }

    private double findPerimeter(double a, double b, double c) {
        return DIV.apply(
                SUM.apply(
                        SUM.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);
    }

    private double findArea(double a, double b, double c, double p) {
        return SQRT.apply(MUL.apply(
                MUL.apply(
                        MUL.apply(p).apply(a)
                ).apply(b)
        ).apply(c));
    }
}
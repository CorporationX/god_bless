package faang.school.godbless;

import java.util.function.Function;

public class Application {
    public static void main(String... args) {
        Application.triangleArea(3, 4, 5);
    }

    static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double halfPerimeter = div.apply(sum.apply(a).apply(sum.apply(b).apply(c))).apply(2d);  // p = (a + b + c) / 2
        System.out.println(halfPerimeter);
        double firstElemOfFormula = halfPerimeter;
        System.out.println(firstElemOfFormula);
        double secondElemOfFormula = sub.apply(halfPerimeter).apply(a);
        System.out.println(secondElemOfFormula);
        double thirdElemOfFormula = sub.apply(halfPerimeter).apply(b);
        System.out.println(thirdElemOfFormula);
        double fourthElemOfFormula = sub.apply(halfPerimeter).apply(c);
        System.out.println(fourthElemOfFormula);
        double multiplicationOfElems = mul.apply(firstElemOfFormula).apply(mul.apply(secondElemOfFormula).apply(mul.apply(thirdElemOfFormula).apply(fourthElemOfFormula)));
        System.out.println(multiplicationOfElems);
        double result = sqrt.apply(multiplicationOfElems);

        return result;
    }

}

package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_25_school;

import java.util.function.Function;

public class Program {
    public static void main(String[] args) {

        System.out.println(triangleArea(3, 4, 5));
    }


    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double p = sum.apply(
                    sum.apply(a).apply(b)
                ).apply(c);
        double halfP = div.apply(p).apply(2.0);
        double subA = sub.apply(halfP).apply(a);
        double subB = sub.apply(halfP).apply(b);
        double subC = sub.apply(halfP).apply(c);
        double multy = mul.apply(
                            mul.apply(
                                    mul.apply(subA).apply(subB)
                            ).apply(subC)
                        ).apply(halfP);

        return sqrt.apply(multy);
    }
}

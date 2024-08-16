package faang.school.godbless.TriangleArea;

import lombok.NonNull;

import java.util.function.Function;

public class triangleArea {
    public static void main(String[] args) {
        System.out.println(getTriangleArea(5,4,3)); // 4*3/2 = 6.0
    }
    public static Double getTriangleArea(@NonNull double a,@NonNull double b,@NonNull double c) throws IllegalArgumentException {
        if (a<=0 || b<=0 || c<=0){
            throw new IllegalArgumentException("there should not be a negative length");
        }
        if (a >= b+c || b>= c+a || c>= a+b){
            throw new IllegalArgumentException("a triangle with such parameters does not exist");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        double halfPerimeter = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);
        double subA = sub.apply(halfPerimeter).apply(a);
        double subB = sub.apply(halfPerimeter).apply(b);
        double subC = sub.apply(halfPerimeter).apply(c);

        double multiplyUnderSQRT = mul.apply(
                                            mul.apply(
                                                    mul.apply(halfPerimeter)
                                                            .apply(subA)
                                            ).apply(subB)
                                    ).apply(subC);

        return sqrt.apply(multiplyUnderSQRT);
    }
}

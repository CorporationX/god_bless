import java.util.function.Function;

public class SquareTriangle {
    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if(a <= 0 || b <= 0 || c <= 0){
            throw new IllegalArgumentException("Длина не может быть меньше ноля");
        }
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);

        double pDiv2 = div.apply(
                sum.apply(
                        sum.apply(a).apply(b)
                ).apply(c)
        ).apply(2.0);

        double pDiv2MinusA = sub.apply(pDiv2).apply(a);
        double pDiv2MinusB = sub.apply(pDiv2).apply(b);
        double pDiv2MinusC = sub.apply(pDiv2).apply(c);

        double result = sqrt.apply(
                mul.apply(
                        mul.apply(pDiv2).apply(pDiv2MinusA)
                ).apply(
                        mul.apply(pDiv2MinusB).apply(pDiv2MinusC)
                )
        );

        return result;
    }
}

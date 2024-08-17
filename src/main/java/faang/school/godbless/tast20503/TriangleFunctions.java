package faang.school.godbless.tast20503;

public class TriangleFunctions {

    public interface Function<T, R> {
        R apply(T t);
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> (y) -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> (y) -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> (y) -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> (y) -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        if(sum.apply(a).apply(b) > c && sum.apply(b).apply(c) > a && sum.apply(a).apply(c) > b) {
            throw new IllegalArgumentException("Данная фигура не является треугольником.");
        }

        Double semiperimeter = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2.0);

        Double area = sqrt.apply(mul.apply(semiperimeter)
                .apply(mul.apply(sub.apply(semiperimeter).apply(a))
                        .apply(mul.apply(sub.apply(semiperimeter).apply(b))
                                .apply(sub.apply(semiperimeter).apply(c)))));;
        return area;
    }
}

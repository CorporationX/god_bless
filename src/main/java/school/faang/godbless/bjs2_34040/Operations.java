package school.faang.godbless.bjs2_34040;

import java.util.function.Function;

public class Operations {
    public static Function<Double, Function<Double, Double>> multiply = (x) -> (y) -> x * y;
    public static Function<Double, Function<Double, Double>> add = (x) -> (y) -> x + y;
    public static Function<Double, Function<Double, Double>> subtract = (x) -> (y) -> x - y;
    public static Function<Double, Function<Double, Double>> divide = (x) -> (y) -> x / y;
    public static Function<Double, Double> squareRoot = Math::sqrt;
}

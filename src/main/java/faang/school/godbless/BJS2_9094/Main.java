package faang.school.godbless.BJS2_9094;

import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    System.out.println(triangleArea(1, 2, 3));
  }

  public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
    Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    Function<Double, Double> sqrt = Math::sqrt;

    Double p = sum.apply(sum.apply(a).apply(b)).apply(c);
    Double pSubA = sub.apply(p).apply(a);
    Double pSubB = sub.apply(p).apply(b);
    Double pSubC = sub.apply(p).apply(c);
    Double mulAll = mul.apply(mul.apply(mul.apply(p).apply(pSubA)).apply(pSubB)).apply(pSubC);

    return sqrt.apply(mulAll);
  }
}

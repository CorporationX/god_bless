package faang.school.godbless.BJS2_5167;

import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    System.out.println(triangleArea(1, 2, 2));
  }

  public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
    isValid(a, b, c);

    Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    Function<Double, Double> sqrt = Math::sqrt;

    double pp = div.apply(sum.apply(c).apply(sum.apply(a).apply(b))).apply(2.0);

    double sub1 = sub.apply(pp).apply(a);
    double sub2 = sub.apply(pp).apply(b);
    double sub3 = sub.apply(pp).apply(c);
    double mul1 = mul.apply(pp).apply(sub1);
    double mul2 = mul.apply(mul1).apply(sub2);
    double mul3 = mul.apply(mul2).apply(sub3);

    return sqrt.apply(mul3);
  }

  private static void isValid(double a, double b, double c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      throw new IllegalArgumentException("Side cannot have a negative value");
    }
  }
}

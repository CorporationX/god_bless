package faang.school.godbless.sprint1.triangleArea;

import java.util.function.Function;

/**
 * @author Evgenii Malkov
 */
public class CustomMath {
  Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
    if (a <= 0 || b <= 0 || c <= 0) {
      throw new IllegalArgumentException("Сторона не может быть меньше или равна нулю");
    }

    Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
    Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
    Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
    Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
    Function<Double, Double> sqrt = Math::sqrt;

    Double semiPerimeter =  div.apply(sum.apply(a).andThen(sum.apply(b)).apply(c)).apply(2d);

    Double semiPerDiffA = sub.apply(semiPerimeter).apply(a);
    Double semiPerDiffB = sub.apply(semiPerimeter).apply(b);
    Double semiPerDiffC = sub.apply(semiPerimeter).apply(c);

    Double product = mul
        .apply(semiPerimeter)
        .andThen(mul.apply(semiPerDiffA))
        .andThen(mul.apply(semiPerDiffB))
        .apply(semiPerDiffC);

    return sqrt.apply(product);
  }
}

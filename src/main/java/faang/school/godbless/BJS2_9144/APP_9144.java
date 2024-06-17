package faang.school.godbless.BJS2_9144;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class APP_9144 {

    public static void main(String[] args) {
        Double area = triangleArea(15, 36, 39.0);
        System.out.println("Area of your triangle is " + area);
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = Math::sqrt;

        Double hypotenuse = sqrt.apply(sum.apply(mul.apply(a).apply(a)).apply(mul.apply(b).apply(b)));
        Double area = 0d;
        try {
            if (a >= 0 && b >= 0 && c >= 0) {
                if (c != hypotenuse) {
                    throw new IllegalArgumentException("Hypotenuse is incorrect, it should be: " + hypotenuse);
                }
                Double p = div.apply(sum.apply(sum.apply(a).apply(b)).apply(c)).apply(2d);
                Double pa = sub.apply(p).apply(a);
                Double pb = sub.apply(p).apply(b);
                Double pc = sub.apply(p).apply(c);
                List<Double> values = Arrays.asList(p, pa, pb, pc);
                Optional<Double> underSqrtValue = values.stream().reduce((x, y) -> mul.apply(x).apply(y));

                if (underSqrtValue.isPresent()) {
                    area = sqrt.apply(underSqrtValue.get());
                }
                return area;
            } else {
                throw new IllegalArgumentException("One of sides of your triangle is less then 0");
            }

        } catch (Exception e) {
            log.warn("there's an error with input occur" + e);
        }
        return area;
    }
}
package school.faang.task_59755;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;

@Slf4j
public class TriangleAreaCalculator {

    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    public static Double calculateTriangleArea(double a, double b, double c) {
        try {
            if (a <= 0 || b <= 0 || c <= 0) {
                throw new IllegalArgumentException("The sides must be more than zero");
            }
            List<Double> listSides = List.of(a, b, c);
            double max = a;
            for (Double listSide : listSides) {
                if (max < listSide) {
                    max = listSide;
                }
            }
            if (SUBTRACT.apply(ADD.apply(a).apply(ADD.apply(b).apply(c))).apply(max) > max) {
                Double halfPerimeter = DIVIDE.apply(ADD.apply(ADD.apply(a).apply(b)).apply(c)).apply(2.0);
                return SQUARE_ROOT.apply(
                        MULTIPLY.apply(halfPerimeter).apply(
                                MULTIPLY.apply(SUBTRACT.apply(halfPerimeter).apply(a)).apply(
                                        MULTIPLY.apply(SUBTRACT.apply(halfPerimeter).apply(b)).apply(
                                                SUBTRACT.apply(halfPerimeter).apply(c))
                                )
                        )
                );
            } else {
                throw new IllegalArgumentException(String.format(
                        "The sides a = %.1f, b = %.1f and c = %.1f are not triangle's sides", a, b, c));
            }
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            double area = calculateTriangleArea(3, 4, 5);
            System.out.println("Площадь треугольника: " + area);
        } catch (NullPointerException e) {
            System.out.println("Triangle with given sides does not exist");
        }

        try {
            double areaTwo = calculateTriangleArea(1, 4, 5);
            System.out.println("Area two: " + areaTwo);
        } catch (NullPointerException e) {
            System.out.println("Triangle with given sides does not exist");
        }

        try {
            double areaThree = calculateTriangleArea(3, -4, 5);
            System.out.println("Area three: " + areaThree);
        } catch (NullPointerException e) {
            System.out.println("Triangle with given sides does not exist");
        }

        try {
            double areaFour = calculateTriangleArea(3, 4, 0);
            System.out.println("Area four: " + areaFour);
        } catch (NullPointerException e) {
            System.out.println("Triangle with given sides does not exist");
        }
    }
}
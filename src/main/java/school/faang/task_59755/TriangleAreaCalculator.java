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
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides must be more than zero");
        }
        List<Double> sides = List.of(a, b, c);
        double max = a;
        for (Double listSide : sides) {
            if (max < listSide) {
                max = listSide;
            }
        }
        if (SUBTRACT.apply(ADD.apply(a).apply(ADD.apply(b).apply(c))).apply(max) <= max) {
            throw new IllegalArgumentException(String.format(
                    "The sides a = %.1f, b = %.1f and c = %.1f are not triangle's sides", a, b, c));
        }
        Double halfPerimeter = DIVIDE.apply(ADD.apply(ADD.apply(a).apply(b)).apply(c)).apply(2.0);
        Double halfPerimeterMinusA = SUBTRACT.apply(halfPerimeter).apply(a);
        Double halfPerimeterMinusB = SUBTRACT.apply(halfPerimeter).apply(b);
        Double halfPerimeterMinusC = SUBTRACT.apply(halfPerimeter).apply(c);
        return SQUARE_ROOT.apply(
                MULTIPLY.apply(halfPerimeter).apply(
                        MULTIPLY.apply(halfPerimeterMinusA).apply(
                                MULTIPLY.apply(halfPerimeterMinusB).apply(halfPerimeterMinusC)
                        )
                )

        );

    }

    public static void main(String[] args) {
        try {
            Double area = calculateTriangleArea(3, 4, 5);
            System.out.println("Area one: " + area);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }

        try {
            Double areaTwo = calculateTriangleArea(1, 4, 5);
            System.out.println("Area two: " + areaTwo);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }

        try {
            Double areaThree = calculateTriangleArea(3, -4, 5);
            System.out.println("Area three: " + areaThree);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }

        try {
            Double areaFour = calculateTriangleArea(3, 4, 0);
            System.out.println("Area four: " + areaFour);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
    }
}
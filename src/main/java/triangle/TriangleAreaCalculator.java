package triangle;

import java.util.function.Function;

public class TriangleAreaCalculator {
    private static final Function<Double, Function<Double, Double>> ADD = (x) -> (y) -> x + y;
    private static final Function<Double, Function<Double, Double>> MULTIPLY = (x) -> (y) -> x * y;
    private static final Function<Double, Function<Double, Double>> SUBTRACT = (x) -> (y) -> x - y;
    private static final Function<Double, Function<Double, Double>> DIVIDE = (x) -> (y) -> x / y;
    private static final Function<Double, Double> SQUARE_ROOT = Math::sqrt;

    private static final String INPUT_DATA_MSG = "Входные данные: a = %f, b = %f, c = %f";
    private static final String ERROR_MSG = "Ошибка: не удалось вычислить площадь." +
                                            "Треугольник с такими сторонами не существует.";
    private static final String INVALID_TRIANGLE_MSG = "Ошибка: треугольник с такими сторонами не существует.";
    private static final String SEMI_PERIMETER_MSG = "Полупериметр (p): %f";
    private static final String PART_MSG = "p - %s = %f";
    private static final String AREA_MSG = "Вычисленная площадь треугольника: %f";

    private static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        boolean valid = ADD.apply(a).apply(b) > c && ADD.apply(a).apply(c) > b && ADD.apply(b).apply(c) > a;
        if (!valid) {
            System.out.println(INVALID_TRIANGLE_MSG);
        }
        return valid;
    }

    public static Double calculateTriangleArea(double a, double b, double c) {
        System.out.printf((INPUT_DATA_MSG) + "%n", a, b, c);
        if (!isValidTriangle(a, b, c)) {
            return null;
        }

        double p = DIVIDE.apply(ADD.apply(a).apply(ADD.apply(b).apply(c))).apply(2.0);
        p = roundToTwoDecimalPlaces(p);
        System.out.printf((SEMI_PERIMETER_MSG) + "%n", p);

        double part1 = SUBTRACT.apply(p).apply(a);
        double part2 = SUBTRACT.apply(p).apply(b);
        double part3 = SUBTRACT.apply(p).apply(c);

        part1 = roundToTwoDecimalPlaces(part1);
        part2 = roundToTwoDecimalPlaces(part2);
        part3 = roundToTwoDecimalPlaces(part3);

        System.out.printf((PART_MSG) + "%n", "a", part1);
        System.out.printf((PART_MSG) + "%n", "b", part2);
        System.out.printf((PART_MSG) + "%n", "c", part3);

        double area = SQUARE_ROOT.apply(
                MULTIPLY.apply(p).apply(
                        MULTIPLY.apply(part1).apply(
                                MULTIPLY.apply(part2).apply(part3)
                        )
                )
        );
        area = roundToTwoDecimalPlaces(area);
        return area;
    }

    public static void main(String[] args) {
        Double area = TriangleAreaCalculator.calculateTriangleArea(3.3, 4.7, 5.2);
        if (area != null) {
            System.out.printf((AREA_MSG) + "%n", area);
        } else {
            System.out.println(ERROR_MSG);
        }
    }
}


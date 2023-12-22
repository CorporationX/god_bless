package faang.school.godbless.BJS2_1115;

import java.util.function.Function;

import static faang.school.godbless.BJS2_1115.Triangle.triangleArea;

public class Main {
    public static void main(String[] args) {

        double a = 3.0;
        double b = 4.0;
        double c = 5.0;

        double area = triangleArea(a, b, c);
        System.out.println("Площадь треугольника: " + area);
    }
}
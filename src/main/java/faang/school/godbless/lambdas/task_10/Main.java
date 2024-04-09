package faang.school.godbless.lambdas.task_10;

import faang.school.godbless.lambdas.task_10.util.TriangleAreaCalculator;

public class Main {
    public static void main(String[] args) {
        TriangleAreaCalculator areaCalculator = new TriangleAreaCalculator();
        double firstTriangleSide = 3.0;
        double secondTriangleSide = 150.0;
        double thirdTriangleSide = 5.0;
        double area = areaCalculator.getTriangleArea(firstTriangleSide, secondTriangleSide, thirdTriangleSide);
        System.out.printf("площадь треугольника со сторонами %.1f, %.1f, %.1f равна %.1f%n",
                firstTriangleSide, secondTriangleSide, thirdTriangleSide, area);

    }
}
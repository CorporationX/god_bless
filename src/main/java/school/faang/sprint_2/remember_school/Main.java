package school.faang.sprint_2.remember_school;

public class Main {
    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        double area = calculator.calculateTriangleArea(3, 4, 5);
        System.out.println("Площадь треугольника: " + area);
    }
}

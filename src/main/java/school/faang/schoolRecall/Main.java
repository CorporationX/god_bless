package school.faang.schoolRecall;

public class Main {
    public static void main(String[] args) {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        int a = 4;
        int b = 5;
        int c = 6;
        double result = calculator.calculateTriangleArea(a, b, c);

        System.out.printf("Triangle's area with sides %d %d %d: %.4f%n", a, b, c, result);
        System.out.println(calculator.calculateTriangleArea(1, 2, 3)); // выдает ошибку, потому что нет такого треугольника
    }
}

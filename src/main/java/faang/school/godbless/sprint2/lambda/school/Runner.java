package faang.school.godbless.sprint2.lambda.school;

public class Runner {

    public static void main(String[] args) {
        TriangleCalculator triangleCalculator = new TriangleCalculator();

        calculateAndPrintArea(triangleCalculator, 3.0, 3.0, 4.0);
        calculateAndPrintArea(triangleCalculator, 1.0, 1.0, 4.0);
    }

    private static void calculateAndPrintArea(TriangleCalculator calculator, double a, double b, double c) {
        try {
            double area = calculator.getTriangleArea(a, b, c);
            System.out.printf("Area of the triangle with sides %.2f, %.2f, and %.2f is: %.2f%n", a, b, c, area);
        } catch (IllegalArgumentException ex) {
            System.out.println("An Exception: " + ex.getMessage());
        }
    }
}

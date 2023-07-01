package faang.school.godbless.backToSchool;

public class App {
    public static void main(String[] args) {
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;

        try {
            double triangleArea = TriangleArea.calculateTriangleArea(a, b, c);
            System.out.println("Area of triangle --> " + triangleArea);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

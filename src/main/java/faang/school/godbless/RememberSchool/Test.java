package faang.school.godbless.RememberSchool;

public class Test {
    public static void main(String[] args) {
        testTriangle();
        testNotTriangle();
    }

    private static void testTriangle() {
        try {
            System.out.println("Triangle (1, 2, 2) | area = " + Triangle.triangleArea(1, 2, 2));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void testNotTriangle() {
        try {
            System.out.println("Triangle (1, 2, 1) | area = " + Triangle.triangleArea(1, 1, 2));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

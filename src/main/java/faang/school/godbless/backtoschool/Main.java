package faang.school.godbless.backtoschool;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(AreaCalculator.triangleArea(3,3,4));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

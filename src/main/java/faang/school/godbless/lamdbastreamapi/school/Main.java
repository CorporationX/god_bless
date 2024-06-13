package faang.school.godbless.lamdbastreamapi.school;

public class Main {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();
        System.out.println(calculator.triangleArea(3, 4, 5));
        System.out.println(calculator.triangleArea(3, 4, 0));
    }
}

package faang.school.godbless.multithreading_2.calculatepi;

public class Main {
    public static void main(String[] args) {
        CalculatorPi calculator = new CalculatorPi();
        System.out.println("Число пи, вычесленное на 100 точках: " + calculator.calculatePi(100));
        System.out.println("Число пи, вычесленное на 1_000 точках: " + calculator.calculatePi(1_000));
        System.out.println("Число пи, вычесленное на 10_000 точках: " + calculator.calculatePi(10_000));
        System.out.println("Число пи, вычесленное на 100_000 точках: " + calculator.calculatePi(100_000));
        System.out.println("Число пи, вычесленное на 1_000_000 точках: " + calculator.calculatePi(1_000_000));
        System.out.println("Число пи, вычесленное на 10_000_000 точках: " + calculator.calculatePi(10_000_000));
        System.out.println("Число пи, вычесленное на 100_000_000 точках: " + calculator.calculatePi(100_000_000));
    }
}

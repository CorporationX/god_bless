package faang.school.godbless.NumberPI;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Pi = " + calculator.calculatePi(100));
        System.out.println("Pi = " + calculator.calculatePi(1000));
        System.out.println("Pi = " + calculator.calculatePi(10000));
        System.out.println("Pi = " + calculator.calculatePi(100000));
        System.out.println("Pi = " + calculator.calculatePi(1000000));
        System.out.println("Pi = " + calculator.calculatePi(10000000));
        System.out.println("Pi = " + calculator.calculatePi(100000000));
    }
}

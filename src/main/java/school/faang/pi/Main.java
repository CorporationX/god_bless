package school.faang.pi;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculatePi(10_000_000));
    }
}
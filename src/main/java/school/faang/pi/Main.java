package school.faang.pi;

public class Main {
    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();
        double numberPi = piCalculator.calculateNumberPi(1000000);
        System.out.printf("Приблизительное значение числа ПИ %f", numberPi);
        ThreadPoolProvider.gracefullyShutdown();
    }
}

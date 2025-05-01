package school.faang.pi;

public class Main {
    public static void main(String[] args) {
        double numberPi = PiCalculator.calculateNumberPi(1000000);
        System.out.printf("Приблизительное значение числа ПИ %f", numberPi);
        ThreadPoolProvider.gracefullyShutdown();
    }
}

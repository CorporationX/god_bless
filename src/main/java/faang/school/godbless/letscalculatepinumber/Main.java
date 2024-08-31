package faang.school.godbless.letscalculatepinumber;

public class Main {
    public static void main(String[] args) {
        PICalculator piCalculator = new PICalculator();
        double pi = piCalculator.calculatePi(10_000_000);
        System.out.println("Estimated value of Pi: " + pi);
    }
}
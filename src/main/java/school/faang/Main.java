package school.faang;

public class Main {
    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();
        System.out.printf("%.20f\n", piCalculator.calculatePi((int) 1e9));
        System.out.printf("%.20f\n", Math.acos(-1));
    }
}

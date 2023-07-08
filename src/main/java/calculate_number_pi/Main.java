package calculate_number_pi;

public class Main {
    public static void main(String[] args) {
        int n = 1000000;
        double pi = PiCalculator.calculatePi(n);
        System.out.println("π: " + pi);
    }
}

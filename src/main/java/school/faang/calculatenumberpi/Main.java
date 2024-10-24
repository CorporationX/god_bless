package school.faang.calculatenumberpi;

public class Main {
    public static void main(String[] args) {
        int numberOfPoints = 1_000_000;
        double pi = PiCalculator.calculatePi(numberOfPoints);
        System.out.println("Approximated value of Pi: " + pi);
    }
}


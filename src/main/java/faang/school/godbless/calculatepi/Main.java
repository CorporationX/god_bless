package faang.school.godbless.calculatepi;

public class Main {

    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();

        double pi = piCalculator.calculatePi(1000);

        System.out.println(String.format("PI number is: %f", pi));
    }
}

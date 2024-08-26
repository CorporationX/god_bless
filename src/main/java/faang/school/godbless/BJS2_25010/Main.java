package faang.school.godbless.BJS2_25010;

public class Main {
    public static void main(String[] args) {
        PiNumberGenerator piNumberGenerator = PiNumberGenerator.INSTANCE;
        System.out.println((piNumberGenerator.calculatePi(1_000_000)));
    }
}

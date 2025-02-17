package school.faang.uber;

public class Main {
    private static final double DEFAULT_DISTANCE = 5.0;
    private static final double DEFAULT_TIME = 10.0;

    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        for (FareType fareType : FareType.values()) {
            double cost = fareCalculator.calculateFare(DEFAULT_DISTANCE, DEFAULT_TIME, fareType.getFareFunction());
            System.out.println(String.format("The cost of the trip on the %s fare: %.2f", fareType.name(), cost));
        }
    }
}

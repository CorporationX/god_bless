package faang.school.godbless.ubermillions;

public class Main {

    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        double actualDistance = 245D;
        double actualTime = 8D;

        double economyCost = fareCalculator.calculateFare(actualDistance, actualTime, (distance, time) -> 1D * distance + 0.5 * time);
        double comfortCost = fareCalculator.calculateFare(actualDistance, actualTime, (distance, time) -> 1.4 * distance + 0.8 * time);
        double businessCost = fareCalculator.calculateFare(actualDistance, actualTime, (distance, time) -> 2D * distance + 2D * time);

        System.out.println(economyCost);
        System.out.println(comfortCost);
        System.out.println(businessCost);
    }
}

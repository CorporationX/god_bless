package faang.school.godbless.millions_uber;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        double economyTripCost = fareCalculator.calculateFare(10.0, 15.0, fareCalculator.economyFare);
        double comfortTripCost = fareCalculator.calculateFare(23., 10., fareCalculator.comfortFare);
        double premiumFare = fareCalculator.calculateFare(40., 20., fareCalculator.premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumFare);
    }

    private static void getCost(double distance, double time, FareCalculator calculator) {

    }
}

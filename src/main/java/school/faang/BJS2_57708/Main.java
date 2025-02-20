package school.faang.BJS2_57708;

public class Main {
    public static void main(String[] args) {
        double distance = 10.0;
        double time = 15.0;
        FareCalculator fareCalculator = new FareCalculator();

        double economyTripCost = fareCalculator.calculateFare(distance, time, Fares.economyFare());
        double comfortTripCost = fareCalculator.calculateFare(distance, time, Fares.comfortFare());
        double premiumTripCost = fareCalculator.calculateFare(distance, time, Fares.premiumFare());

        System.out.printf("Стоимость поездки на тарифе Economy: %.2f\n", economyTripCost);
        System.out.printf("Стоимость поездки на тарифе Comfort: %.2f\n", comfortTripCost);
        System.out.printf("Стоимость поездки на тарифе Premium: %.2f\n", premiumTripCost);
    }
}

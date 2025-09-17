package school.faang.bjs2_88006;

public class Main {
    public static void main(String[] args) {
        int distanceToHomeKm = 10;
        int timeToHomeMinutes = 20;

        int cheapTripToHome = FareCalculator.calculateFare(distanceToHomeKm, timeToHomeMinutes,
                (distance, time) -> distance * time * 2);
        int expenciveTripToHome = FareCalculator.calculateFare(distanceToHomeKm, timeToHomeMinutes,
                (distance, time) -> distance * time * 3);
        int luxaryTripToHome = FareCalculator.calculateFare(distanceToHomeKm, timeToHomeMinutes,
                (distance, time) -> distance * time * 4);

        System.out.printf("Доехать до дома дешево стоит: %d руб.%n", cheapTripToHome);
        System.out.printf("Доехать до дома дорого стоит: %d руб.%n", expenciveTripToHome);
        System.out.printf("Доехать до дома роскошно стоит: %d руб.%n", luxaryTripToHome);
    }
}

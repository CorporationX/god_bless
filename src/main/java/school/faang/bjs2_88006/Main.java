package school.faang.bjs2_88006;

public class Main {
    public static void main(String[] args) {
        int distanceToHome = 10; //km
        int timeToHome = 20; //min

        int cheapTripToHome = FareCalculator.calculateFare(distanceToHome, timeToHome,
                (distance, time) -> distance * time * 2);
        int expenciveTripToHome = FareCalculator.calculateFare(distanceToHome, timeToHome,
                (distance, time) -> distance * time * 3);
        int luxaryTripToHome = FareCalculator.calculateFare(distanceToHome, timeToHome,
                (distance, time) -> distance * time * 4);

        System.out.printf("Доехать до дома дешево стоит: %d руб.%n", cheapTripToHome);
        System.out.printf("Доехать до дома дорого стоит: %d руб.%n", expenciveTripToHome);
        System.out.printf("Доехать до дома роскошно стоит: %d руб.%n", luxaryTripToHome);
    }
}

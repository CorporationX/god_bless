package sprint3task4;
//создать систему, которая будет принимать расстояние и время
//поездки, а затем вычислять стоимость на основе различных тарифов
import java.util.function.BiFunction;
//класс FareCalculator, который будет использовать
//BiFunction для подсчёта стоимости поездки.
public class FareCalculator {
    //public double distance;
    //public double time;
    //будет использовать BiFunction для подсчёта стоимости поездки
    private double calculateFare(double distance, double time,
                                 BiFunction <Double, Double, Double> fare) {
        BiFunction <Double, Double, Double> fare = fare.apply(distance, time);
    }


    public static void main(String[] args) {

        FareCalculator fareCalculator = new FareCalculator();

// Создание тарифов
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

// Примеры поездок
        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
    }
}
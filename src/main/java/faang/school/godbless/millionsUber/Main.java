package faang.school.godbless.millionsUber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> econom = (s, t) -> s * 2 + t * 2;
        BiFunction<Integer, Integer, Integer> standart = (s, t) -> s * 4 + t * 2;
        BiFunction<Integer, Integer, Integer> bisnen = (s, t) -> s * 5 + t * 2;

        FareCalculator fareCalculator = new FareCalculator();
        System.out.println("Эконом - " + fareCalculator.calculateFare(20, 50, econom));
        System.out.println("Стандарт - " + fareCalculator.calculateFare(20, 50, standart));
        System.out.println("Бизнес - " + fareCalculator.calculateFare(20, 50, bisnen));
    }
}

package faang.school.godbless.lambda.task12uber;

public class Main {
    public static void main(String[] args) {
        // Расстояние в метрах, время в минутах
        System.out.println(FareCalculator.calculator(2000, 6, FareCalculator.getTariffEco()));
        System.out.println(FareCalculator.calculator(2000, 6, FareCalculator.getTariffComfort()));
        System.out.println(FareCalculator.calculator(2000, 6, FareCalculator.getTariffSuper()));
    }
}

package faang.school.godbless.secondSprint.Uber;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        double tariffEconomy = fareCalculator.calculateFare(20, 0.5, (dis, time) -> dis * time * 50);
        double tariffSelect = fareCalculator.calculateFare(20, 0.5, (dis, time) -> dis * time * 65);
        double tariffBlack = fareCalculator.calculateFare(20, 0.5, (dis, time) -> dis * time * 110);

        System.out.println("Стоимость поездки по тарифу 'economy' будет равна: " + tariffEconomy + " рублей");
        System.out.println("Стоимость поездки по тарифу 'select' будет равна: " + tariffSelect + " рублей");
        System.out.println("Стоимость поездки по тарифу 'black' будет равна: " + tariffBlack + " рублей");
    }
}

package school.faang.calculatingheroesofmightandmagic;

import java.util.ArrayList;
import java.util.List;

public class Army<T extends Hero> {
    public List<T> listOfAllHeroes = new ArrayList<>();

    public void addHeroToList(T hero) {
        listOfAllHeroes.add(hero);
    }

    public int calculateTotalPower() {
        List<HeroPowerCalculator> calculators = new ArrayList<>();

        for (T hero : listOfAllHeroes) {
            HeroPowerCalculator calculator = new HeroPowerCalculator(hero);
            calculators.add(calculator);
            calculator.start();
        }

        int totalPower = 0;

        for (HeroPowerCalculator calculator : calculators) {
            try {
                calculator.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted" + calculator.getName());
                Thread.currentThread().interrupt();
            }
            totalPower += calculator.getPower();
        }
        return totalPower;
    }
}
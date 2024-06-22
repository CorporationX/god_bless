package faang.school.godbless.sprint3.armyOfSwordsAndMagicHeroes;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<ArmyItem> armyItems = Arrays.asList(new Archer(25), new Swordsman(40), new Mage(50), new Mage(20));
        Army army = new Army(armyItems);
        // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}

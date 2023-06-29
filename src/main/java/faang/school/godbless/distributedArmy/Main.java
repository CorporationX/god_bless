package faang.school.godbless.distributedArmy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Warrior> warriorsList = new ArrayList<>();
        warriorsList.add(new Archer("Archer", 35));
        warriorsList.add(new Swordsman("Swordsman", 50));
        warriorsList.add(new Mage("Mage", 80));
        Army army = new Army(warriorsList);
        System.out.println(army.calculateTotalPower());
    }
}

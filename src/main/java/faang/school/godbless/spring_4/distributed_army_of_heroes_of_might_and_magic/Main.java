package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.*;
import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.armys.Army;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        addUnit(army, new Archer(25));
        addUnit(army, new Swordsman(45));
        addUnit(army, new Mage(30));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }

    private static void addUnit(Army army, Divisions divisions) {
        try {
            army.addUnit(divisions);
        } catch (InterruptedException e) {
            return;
        }
    }
}

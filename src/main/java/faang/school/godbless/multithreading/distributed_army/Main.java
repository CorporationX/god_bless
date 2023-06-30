package faang.school.godbless.multithreading.distributed_army;

import faang.school.godbless.multithreading.distributed_army.creature.Archer;
import faang.school.godbless.multithreading.distributed_army.creature.Mage;
import faang.school.godbless.multithreading.distributed_army.creature.Swordsman;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(1000));
        army.addUnit(new Swordsman(2000));
        army.addUnit(new Mage(1500));
        System.out.println("Total power: " + army.calculateTotalPower());
    }
}

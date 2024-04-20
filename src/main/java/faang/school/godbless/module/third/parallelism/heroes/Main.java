package faang.school.godbless.module.third.parallelism.heroes;

import faang.school.godbless.module.third.parallelism.heroes.creature.Archer;
import faang.school.godbless.module.third.parallelism.heroes.creature.Mage;
import faang.school.godbless.module.third.parallelism.heroes.creature.Swordsman;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4
        
        System.out.printf("Total army power: %d", army.calculateTotalPower());
    }
}

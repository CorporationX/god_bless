package faang.school.godbless;

import faang.school.godbless.solger.Archer;
import faang.school.godbless.solger.Mage;
import faang.school.godbless.solger.Swordsman;

public class Application {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
        System.out.println("God Bless!");
    }
}
package faang.school.godbless.HoMMarmy;

import faang.school.godbless.HoMMarmy.units.Archangel;
import faang.school.godbless.HoMMarmy.units.Archer;
import faang.school.godbless.HoMMarmy.units.Mage;
import faang.school.godbless.HoMMarmy.units.Swordsman;

public class Main {
    public static void main(String... args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4
        army.addUnit(new Archangel(50), 5);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}

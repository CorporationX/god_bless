package school.faang.BJS235895;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));   // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50));     // считаем в потоке 3
        army.addUnit(new Mage(20));     // считаем в потоке 4

        AtomicInteger totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower.toString());
    }
}

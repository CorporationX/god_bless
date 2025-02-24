package school.faang.BJS235895;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        AtomicInteger totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower.toString());
    }
}

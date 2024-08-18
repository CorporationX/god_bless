package faang.school.godbless.task.multithreading.might.and.magic;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Army army = new Army(new ArrayList<>());
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}

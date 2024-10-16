package school.faang.geroes_thord_and_magic_BJS2_35856;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(new ArrayList<>());
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower(army.getUnits());
        System.out.println("Общая сила армии: " + totalPower);
    }
}
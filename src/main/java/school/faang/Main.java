package school.faang;

import school.faang.Fighter.Archer;
import school.faang.Fighter.Fighter;
import school.faang.Fighter.Mage;
import school.faang.Fighter.Swordsman;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());
        army.addUnit(new Mage());

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }

}
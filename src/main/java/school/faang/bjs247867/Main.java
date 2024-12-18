package school.faang.bjs247867;

import school.faang.bjs247867.model.Archer;
import school.faang.bjs247867.model.Mage;
import school.faang.bjs247867.model.Swordsman;
import school.faang.bjs247867.servcie.Army;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}

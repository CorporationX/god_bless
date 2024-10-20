package school.faang.bjs2_35926;

import school.faang.bjs2_35926.model.Archer;
import school.faang.bjs2_35926.model.Mage;
import school.faang.bjs2_35926.model.Swordsman;
import school.faang.bjs2_35926.service.Army;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Archer(35));
        army.addUnit(new Swordsman(30));
        army.addUnit(new Mage(45));
        army.addUnit(new Archer(15));
        army.addUnit(new Swordsman(55));
        army.addUnit(new Mage(60));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}

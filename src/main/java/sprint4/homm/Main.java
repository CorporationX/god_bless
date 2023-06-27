package sprint4.homm;

import sprint4.homm.unit.Archer;
import sprint4.homm.unit.Griffon;
import sprint4.homm.unit.Mage;
import sprint4.homm.unit.Swordsman;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Archer(15));
        army.addUnit(new Mage(35));
        army.addUnit(new Swordsman(30));
        army.addUnit(new Archer(15));
        army.addUnit(new Griffon(80));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}

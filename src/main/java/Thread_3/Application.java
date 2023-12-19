package Thread_3;

import Thread_3.Units.Archer;
import Thread_3.Units.Mage;
import Thread_3.Units.Swordsman;

public class Application {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(15));
        army.addUnit(new Swordsman(22));
        army.addUnit(new Mage(4));

        System.out.println("Total army power: " + army.calculateTotalPower());
    }
}

package school.faang.army;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Archer(35));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        List<Unit> units = army.getUnits();

        int totalPower = army.calculateTotalPower();
        System.out.println("The total power of army: " + totalPower);
    }
}

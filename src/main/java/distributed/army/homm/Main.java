package distributed.army.homm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Unit> units = new ArrayList<>();
        units.add(new Archer(25));
        units.add(new Archer(25));
        units.add(new Swordsman(50));
        units.add(new Swordsman(50));
        units.add(new Mage(75));
        units.add(new Mage(75));
        units.add(new Mage(75));

        Army army = new Army(units);
        int totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }
}

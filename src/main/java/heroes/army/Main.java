package heroes.army;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Unit> unitList = List.of(new Archer(25), new Swordsman(40), new Mage(50),
                new Archer(25), new Swordsman(40), new Mage(50),
                new Archer(25), new Swordsman(40), new Mage(50));
        Army army = new Army(unitList);
        System.out.println(army.calculateTotalPower(unitList));


    }
}

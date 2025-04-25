package school.faang.sword_and_magic;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(25));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(100));
        swordsmen.addUnit(new Swordsman(100));

        Squad mages = new Squad();
        mages.addUnit(new Mage(50));
        mages.addUnit(new Mage(50));
        mages.addUnit(new Mage(50));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power = " + totalPower + " points");
    }
}

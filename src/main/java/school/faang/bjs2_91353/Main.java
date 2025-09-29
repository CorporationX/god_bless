package school.faang.bjs2_91353;

import school.faang.bjs2_91353.unit.Archer;
import school.faang.bjs2_91353.unit.Mage;
import school.faang.bjs2_91353.unit.Swordsman;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad();
        archers.addUnits(new Archer(25));
        archers.addUnits(new Archer(30));
        archers.addUnits(new Archer(30));

        Squad swordsmen = new Squad();
        swordsmen.addUnits(new Swordsman(15));
        swordsmen.addUnits(new Swordsman(20));

        Squad mages = new Squad();
        mages.addUnits(new Mage(35));
        mages.addUnits(new Mage(35));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}

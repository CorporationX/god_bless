package school.faang.bjs2_91272;

import school.faang.bjs2_91272.character.Archer;
import school.faang.bjs2_91272.character.Mage;
import school.faang.bjs2_91272.character.Swordsman;
import school.faang.bjs2_91272.character_groups.Army;
import school.faang.bjs2_91272.character_groups.Squad;
import school.faang.bjs2_91272.character_groups.Squad.UnitClass;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad(UnitClass.ARCHERS, new Archer(), new Archer(), new Archer());
        Squad swordsmen = new Squad(UnitClass.SWORDSMEN, new Swordsman(), new Swordsman(), new Swordsman());
        Squad mages = new Squad(UnitClass.MAGES, new Mage(), new Mage(), new Mage());

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}

package school.faang.army_of_heroes_bjs2_91335;

import java.util.concurrent.ExecutionException;

public class ArmyMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Squad archers = new Squad();
        archers.addUnit(new Archer(70));
        archers.addUnit(new Archer(35));
        archers.addUnit(new Archer(66));

        Squad swordsmans = new Squad();
        swordsmans.addUnit(new Swordsman(65));
        swordsmans.addUnit(new Swordsman(30));
        swordsmans.addUnit(new Swordsman(50));

        Squad mages = new Squad();
        mages.addUnit(new Mage(100));
        mages.addUnit(new Mage(90));
        mages.addUnit(new Mage(95));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmans);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        int archersPower = archers.calculateSquadPower();
        int swordsmansPower = swordsmans.calculateSquadPower();
        int magesPower = mages.calculateSquadPower();

        System.out.printf("archersPower: %d\nswordsmansPower: %d\nmagesPower: %d\ntotalPower: %d\n",
                archersPower, swordsmansPower, magesPower, totalPower);
    }
}

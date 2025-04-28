package school.faang.multithreading.parallelism.bjs2_72273.heros_army;

import lombok.extern.slf4j.Slf4j;
import school.faang.multithreading.parallelism.bjs2_72273.heros_army.fighters.Archer;
import school.faang.multithreading.parallelism.bjs2_72273.heros_army.fighters.Mage;
import school.faang.multithreading.parallelism.bjs2_72273.heros_army.fighters.Swordsman;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad();
        archers.addFighter(new Archer(35));
        archers.addFighter(new Archer(25));
        archers.addFighter(new Archer(50));
        archers.addFighter(new Archer(43));
        archers.addFighter(new Archer(22));

        Squad swordsmen = new Squad();
        swordsmen.addFighter(new Swordsman(41));
        swordsmen.addFighter(new Swordsman(49));
        swordsmen.addFighter(new Swordsman(53));
        swordsmen.addFighter(new Swordsman(25));
        swordsmen.addFighter(new Swordsman(17));

        Squad mages = new Squad();
        mages.addFighter(new Mage(37));
        mages.addFighter(new Mage(29));
        mages.addFighter(new Mage(17));
        mages.addFighter(new Mage(44));
        mages.addFighter(new Mage(50));

        Army army = new Army();
        army.add(archers);
        army.add(swordsmen);
        army.add(mages);

        int totalPower = army.calculateTotalPower();
        log.info("Total army power: " + totalPower);
    }
}

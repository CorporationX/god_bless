package school.faang.task_61247;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_61247.unit.Archer;
import school.faang.task_61247.unit.Mage;
import school.faang.task_61247.unit.Swordsman;

@Slf4j
public class Main {
    private static final int DEFAULT_SWORDSMAN_POWER = 75;
    private static final int DEFAULT_MAGE_POWER = 50;
    private static final int DEFAULT_ARCHER_POWER = 25;

    public static void main(String[] args) throws InterruptedException {
        final Army army = new Army();

        final Squad<Archer> archers = new Squad<>();
        archers.addUnit(new Archer(DEFAULT_ARCHER_POWER));
        archers.addUnit(new Archer(DEFAULT_ARCHER_POWER));
        archers.addUnit(new Archer(DEFAULT_ARCHER_POWER));

        final Squad<Mage> mages = new Squad<>();
        mages.addUnit(new Mage(DEFAULT_MAGE_POWER));
        mages.addUnit(new Mage(DEFAULT_MAGE_POWER));

        final Squad<Swordsman> swordsman = new Squad<>();
        swordsman.addUnit(new Swordsman(DEFAULT_SWORDSMAN_POWER));

        army.addSquad(archers);
        army.addSquad(mages);
        army.addSquad(swordsman);

        log.info("The army's power is: {}", army.calculateArmyPower());
    }
}

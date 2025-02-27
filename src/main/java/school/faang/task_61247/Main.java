package school.faang.task_61247;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_61247.character.Archer;
import school.faang.task_61247.character.Mage;
import school.faang.task_61247.character.Swordsman;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Army army = new Army();

        final Squad<Archer> archers = new Squad<>();
        archers.addUnit(new Archer());
        archers.addUnit(new Archer());
        archers.addUnit(new Archer());

        final Squad<Mage> mages = new Squad<>();
        mages.addUnit(new Mage());
        mages.addUnit(new Mage());

        final Squad<Swordsman> swordsman = new Squad<>();
        swordsman.addUnit(new Swordsman());

        army.addSquad(archers);
        army.addSquad(mages);
        army.addSquad(swordsman);

        log.info("The army's power is: {}", army.calculateArmyPower());
    }
}

package school.faang.magic_army;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(DefaultPowers.ARCHER_POWER));
        army.addUnit(new Swordsman(DefaultPowers.SWORDSMAN_POWER));
        army.addUnit(new Mage(DefaultPowers.MAGE_POWER));
        army.addUnit(new Mage(DefaultPowers.MAGE_POWER));
        army.addUnit(new Swordsman(DefaultPowers.SWORDSMAN_POWER));
        army.addUnit(new Archer(DefaultPowers.ARCHER_POWER));

        int totalPower = army.calculateTotalPower();
        log.info("Total army power: {}", totalPower);
    }
}

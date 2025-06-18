package school.faang.parallelsystem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnitsArmyTesting {
    public static void main(String[] args) {
        Squad archerSquad = new Squad();
        archerSquad.addUnit(new Archer(20));
        archerSquad.addUnit(new Archer(20));

        Squad swordsmanSquad = new Squad();
        swordsmanSquad.addUnit(new Swordsman(40));
        swordsmanSquad.addUnit(new Swordsman(40));

        Squad mageSquad = new Squad();
        mageSquad.addUnit(new Mage(50));
        mageSquad.addUnit(new Mage(50));

        Army unitArmy = new Army();
        unitArmy.addSquad(archerSquad);
        unitArmy.addSquad(swordsmanSquad);
        unitArmy.addSquad(mageSquad);

        log.info("Боевая мощь армии юнитов: {}", unitArmy.calculateTotalPower());
    }
}

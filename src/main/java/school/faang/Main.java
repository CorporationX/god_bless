package school.faang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Unit.Archer archer  = new Unit.Archer(25);
        Unit.Archer secondArcher  = new Unit.Archer(27);
        Squad archers = new Squad();
        archers.addUnit(archer, secondArcher);
        System.out.println("Общая сила отряда лучников: " + archers.calculateSquadPower());

        Unit.Warrior warrior = new Unit.Warrior(35);
        Unit.Warrior secondWarrior = new Unit.Warrior(39);
        Squad warriors = new Squad();
        warriors.addUnit(warrior, secondWarrior);
        System.out.println("Общая сила отряда воинов: " + warriors.calculateSquadPower());

        Unit.Mage mage = new Unit.Mage(50);
        Unit.Mage secondMage = new Unit.Mage(67);
        Squad mages = new Squad();
        mages.addUnit(mage, secondMage);
        System.out.println("Общая сила отряда магов: " + mages.calculateSquadPower());

        Army army = new Army();
        army.addSquad(archers, warriors, mages);
        try {
            int totalPower = army.calculateArmyPower();
            System.out.println("Общая сила армии: " + totalPower);
        } catch (InterruptedException e) {
            log.info("Произошла ошибка: " + e.getMessage());
        }
    }
}
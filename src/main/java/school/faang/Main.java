package school.faang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Archer archer  = new Archer(25);
        Archer secondArcher  = new Archer(27);
        Squad archers = new Squad();
        archers.addUnit(archer, secondArcher);
        System.out.println("Общая сила отряда лучников: " + archers.calculateSquadPower());

        Warrior warrior = new Warrior(35);
        Warrior secondWarrior = new Warrior(39);
        Squad warriors = new Squad();
        warriors.addUnit(warrior, secondWarrior);
        System.out.println("Общая сила отряда воинов: " + warriors.calculateSquadPower());

        Mage mage = new Mage(50);
        Mage secondMage = new Mage(67);
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
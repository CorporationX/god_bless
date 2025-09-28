package school.faang.bjs2_91314;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character longBowArcher = new Archer(50, "Nick");
        Character shortBowArcher = new Archer(45, "Maverick");
        Character crossbowArcher = new Archer(137, "Silvana");
        Squad archers = new Squad("archers");
        archers.addCharacter(longBowArcher);
        archers.addCharacter(shortBowArcher);
        archers.addCharacter(crossbowArcher);

        Character voidStuffMage = new Mage(50, "Frank");
        Character fireStuffMage = new Mage(45, "Bob");
        Character iceGauntletMage = new Mage(31, "Stan");
        Squad mages = new Squad("mages");
        mages.addCharacter(iceGauntletMage);
        mages.addCharacter(fireStuffMage);
        mages.addCharacter(voidStuffMage);

        Character greatswordWarrior = new Warrior(57, "Alex");
        Character swordAndShieldWarrior = new Warrior(45, "Michael");
        Character greataxeWarrior = new Warrior(37, "John");
        Squad warriors = new Squad("warriors");
        warriors.addCharacter(greatswordWarrior);
        warriors.addCharacter(swordAndShieldWarrior);
        warriors.addCharacter(greataxeWarrior);

        Army army = new Army();

        army.addSquadToArmy(archers);
        army.addSquadToArmy(mages);
        army.addSquadToArmy(warriors);

        log.info("Сила отряда {}: {}!", archers.getName(), archers.calculateSquadPower());
        log.info("Сила отряда {}: {}!", mages.getName(), mages.calculateSquadPower());
        log.info("Сила отряда {}: {}!", warriors.getName(), warriors.calculateSquadPower());
        log.info("Общая сила армии: {}!",  army.calculateTotalPower());
    }
}


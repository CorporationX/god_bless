package school.faang.bjs2_79240;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character megaWarrior = new Warrior("MegaWarrior", 10, 10, 10);
        log.info("MegaWarrior: {}", megaWarrior);
        Character megaArcher = new Archer("MegaArcher", 10, 10, 10);
        log.info("MegaArcher: {}", megaArcher);

        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");
        log.info("Warrior: {}", warrior);
        log.info("Archer: {}", archer);

        do {
            warrior.attack(archer);
            log.info("Archer Health: {}", archer.getHealth());
            archer.attack(warrior);
            log.info("Warrior Health: {}", warrior.getHealth());
        } while (warrior.getHealth() > 0 && archer.getHealth() > 0);
    }
}

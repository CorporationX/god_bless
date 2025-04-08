package school.faang.bjs2_68146;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Bulbo");
        Archer archer = new Archer("Lagovaz");

        log.info("Warrior's health: {}", warrior.getHealth());
        log.info("Archer's health: {}", archer.getHealth());

        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        warrior.attack(archer);

        log.info("Warrior's health: {}", warrior.getHealth());
        log.info("Archer's health: {}", archer.getHealth());
    }
}
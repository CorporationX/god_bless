package school.faang.bjs2_85572;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Pavel");
        Archer archer = new Archer("Alesha");

        log.info("{Archer before cycle} {}", archer);
        for (int i = 0; i < 15; i++) {
            warrior.attack(archer);
            log.info("{Archer after attack} {}", archer);
        }
    }
}
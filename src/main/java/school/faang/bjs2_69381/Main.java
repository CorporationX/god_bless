package school.faang.bjs2_69381;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Чел1");
        Character archer = new Archer("Чел2");
        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);

        log.info(String.valueOf(warrior.health));
        log.info(String.valueOf(archer.health));
    }
}
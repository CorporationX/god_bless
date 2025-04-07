package school.faang.abstraction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        archer.attack(warrior);
        warrior.attack(archer);
        log.info("Здоровье лучника = {}, Здоровье воина = {}", archer.getHealth(), warrior.getHealth());

        attackSeveralTimes(warrior, archer, 20);
        log.info("Здоровье лучника = {}, Здоровье воина = {}", archer.getHealth(), warrior.getHealth());
    }

    public static void attackSeveralTimes(Character damageDealer, Character damageReceiver, int repeat) {
        for (int i = 0; i < repeat; i++) {
            damageDealer.attack(damageReceiver);
        }
    }
}

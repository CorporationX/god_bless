package school.faang.bjs2_68275.abstraction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        log.info("warrior {}", warrior);
        log.info("archer {}", archer);
        log.info("---------------attacks are starting---------------");
        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            warrior.attack(archer);
            log.info("warrior attacks archer, archer's health = {} ", archer.getHealth());
            archer.attack(warrior);
            log.info("archer attacks warrior, warrior's health = {} ", warrior.getHealth());
        }
        if (archer.getHealth() > warrior.getHealth()) {
            log.info("---------------{} IS A WINNER---------------", archer.getName());
        } else if (archer.getHealth() < warrior.getHealth()) {
            log.info("---------------{} IS A WINNER---------------", warrior.getName());
        } else {
            log.info("---------------THERE IS A DEAD HEAT---------------");
        }

    }
}

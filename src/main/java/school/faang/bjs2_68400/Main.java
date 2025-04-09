package school.faang.bjs2_68400;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_68400.characters.Archer;
import school.faang.bjs2_68400.characters.Character;
import school.faang.bjs2_68400.characters.Warrior;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        for (int i = 0; i < 11; i++) {
            if (warrior.getHealth() > 0 && archer.getHealth() > 0) {
                log.info("Воин атакует!");
                warrior.attack(archer);
                log.info("Здоровье лучника: {}", archer.getHealth());

                log.info("Лучник атакует!");
                archer.attack(warrior);
                log.info("Здоровье воина: {}", warrior.getHealth());
            } else {

                if (warrior.getHealth() <= 0) {
                    log.info("Воин убит!");
                }

                if (archer.getHealth() <= 0) {
                    log.info("Лучник убит!");
                }
            }
        }
    }
}
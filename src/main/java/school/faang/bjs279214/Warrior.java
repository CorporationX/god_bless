package school.faang.bjs279214;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {


    public Warrior(String name, int strength, int dexterity, int intellect) {
        super(name, strength, dexterity, intellect);
    }

    public Warrior(String name) {
        super(name, 10, 3, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.getHealth() != 0) {
            opponent.setHealth(opponent.getHealth() - strength);
            if (opponent.getHealth() < 0) {
                opponent.setHealth(0);


            }
            log.info("Противник получил урон.");
            log.info("Оставшееся HP у {} {}", opponent.getName(), opponent.getHealth());
        }
        if (opponent.getHealth() == 0) {
            log.info("Противник умер хватит его бить");
        }
    }
}

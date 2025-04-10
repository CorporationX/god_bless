package abstraction.abstraction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {
    private String name;
    private int power;
    private int agility;
    private int intellect;
    private int health;

    public Archer(String name) {
        super(name, CharacterConfiguration.getArcherPower(),
                CharacterConfiguration.getArcherAgility(),
                CharacterConfiguration.getArcherIntellect());
    }

    public Archer(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    protected void attack(Character opponent) {
        while (opponent.getHealth() != 0) {
            opponent.setDamage(this.agility);
        }
        log.info("Archer defeat opponent {} !", opponent.getName());
    }
}

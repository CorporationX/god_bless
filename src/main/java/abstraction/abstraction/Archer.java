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
        super(name, CharacterConfiguration.ARCHER_POWER,
                CharacterConfiguration.ARCHER_AGILITY,
                CharacterConfiguration.ARCHER_INTELLECT);
    }

    public Archer(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    protected void attack(Character opponent) {
        while (checkOpponentHealth(opponent.getHealth(), this.agility)) {
            opponent.setHealth(opponent.getHealth() - this.agility);
        }
        log.info("Warrior {} is defeated!", opponent.getName());
    }
}

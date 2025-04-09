package abstraction.abstraction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {
    private String name;
    private int power;
    private int agility;
    private int intellect;
    private int health;

    public Warrior(String name) {
        super(name, CharacterConfiguration.WARRIOR_POWER,
                CharacterConfiguration.WARRIOR_AGILITY,
                CharacterConfiguration.WARRIOR_INTELLECT);
    }

    public Warrior(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    protected void attack(Character opponent) {
        while (checkOpponentHealth(opponent.getHealth(), this.power)) {
            opponent.setHealth(opponent.getHealth() - this.power);
        }
        log.info("Warrior {} is defeated!", opponent.getName());
    }
}

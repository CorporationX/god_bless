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
        super(name, CharacterConfiguration.getWarriorPower(),
                CharacterConfiguration.getWarriorAgility(),
                CharacterConfiguration.getWarriorIntellect());
    }

    public Warrior(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    protected void attack(Character opponent) {
        while (opponent.getHealth() != 0) {
            opponent.setDamage(this.power);
        }
        log.info("Warrior defeat opponent {} !", opponent.getName());
    }
}

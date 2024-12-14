package school.faang.task_43950;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 1;
    private static final int DEFAULT_INTELLIGENCE = 3;
    private static final String ICON_ATTACK = "🔪";

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        int damage = this.getStrength();

        log.info("{}|{} {} {}|{}", this.getHealth(), this.getName(), ICON_ATTACK, target.getName(), target.getHealth());

        target.takeDamage(damage);
    }
}
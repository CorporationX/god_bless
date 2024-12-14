package school.faang.task_43950;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;
    private static final String ICON_ATTACK = "🏹";

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        int damage = this.getAgility();

        log.info("{}|{} {} {}|{}", this.getHealth(), this.getName(), ICON_ATTACK, target.getName(), target.getHealth());

        target.takeDamage(damage);
    }
}
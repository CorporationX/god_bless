package school.faang.abstraction_abstraction.BJS2_56401;

import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Warrior extends Character {
    private static final Logger LOGGER = LoggerFactory.getLogger(Warrior.class);

    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(@NonNull String name) {
        super(name);
        setStrength(WARRIOR_STRENGTH);
        setIntelligence(WARRIOR_INTELLIGENCE);

        LOGGER.info("Warrior created");
    }

    @Override
    public void attack(Character opponent) {
        if (opponent == null) {
            LOGGER.warn("Null opponent");
            throw new NullPointerException(opponent + " is null");
        }
        LOGGER.info("{} attacking {}", this.getName(), opponent.getName());

        opponent.setHealth(opponent.getHealth() - getStrength());

        LOGGER.info("{} attacked {}", this.getName(), opponent.getName());
    }

}

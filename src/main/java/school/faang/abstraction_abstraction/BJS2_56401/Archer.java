package school.faang.abstraction_abstraction.BJS2_56401;

import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archer extends Character {
    private static final Logger LOGGER = LoggerFactory.getLogger(Archer.class);

    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;

    public Archer(@NonNull String name) {
        super(name);
        setStrength(ARCHER_STRENGTH);
        setAgility(ARCHER_AGILITY);

        LOGGER.info("Archer created");
    }

    @Override
    public void attack(Character opponent) {
        if (opponent == null) {
            LOGGER.warn("Null opponent");
            throw new NullPointerException(opponent + " is null");
        }
        LOGGER.info("{} attacking {}", this.getName(), opponent.getName());

        opponent.setHealth(opponent.getHealth() - getAgility());

        LOGGER.info("{} attacked {}", this.getName(), opponent.getName());
    }
}

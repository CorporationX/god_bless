package bjs256450;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Archer extends Character {
    private static final Logger logger = LoggerFactory.getLogger(Archer.class);

    public Archer(String name) {
        super(name);
        super.strength = 3;
        super.agility = 10;
        super.intellect = 5;
    }

    @Override
    public void attack(Character opponent) {
        if (!isHealthNotLessThanZero(this)) {
            throw new IllegalArgumentException("Fighter " + this.getName() + " always killed, cannot attack");
        }
        if (isHealthNotLessThanZero(opponent)) {
            int opponentHealthAfterAttack = opponent.getHealth() - this.getAgility();
            if (isHealthNotLessThanZero(opponent)) {
                opponent.setHealth(opponentHealthAfterAttack);
                if (opponent.getHealth() == 0) {
                    logger.info("Fighter {} killed", opponent.getName());
                }
            }
        }
    }
}


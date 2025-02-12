package bjs256450;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Warrior extends Character {
    private static final Logger logger = LoggerFactory.getLogger(Warrior.class);

    public Warrior(String name) {
        super(name);
        super.strength = 10;
        super.agility = 5;
        super.intellect = 3;
    }

    @Override
    public void attack(Character opponent) {
        if (!isHealthNotLessThanZero(this)) {
            throw new IllegalArgumentException("Fighter " + this.getName() + " always killed, cannot attack");
        }
        if (isHealthNotLessThanZero(opponent)) {
            int opponentHealthAfterAttack = opponent.getHealth() - this.getStrength();
            if (isHealthNotLessThanZero(opponent)) {
                opponent.setHealth(opponentHealthAfterAttack);
                if (opponent.getHealth() == 0) {
                    logger.info("Fighter {} killed", opponent.getName());
                }
            }
        }
    }
}

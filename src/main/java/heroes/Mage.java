package heroes;

import lombok.AllArgsConstructor;

import java.util.logging.Logger;

@AllArgsConstructor
public class Mage implements Warrior {
    private static final Logger logger = Logger.getLogger(Mage.class.getName());
    private final int power;

    @Override
    public int getPower() {
        logger.info("java.heroes.Mage created with power: " + power);
        return power;
    }
}

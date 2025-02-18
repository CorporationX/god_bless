package heroes;

import lombok.AllArgsConstructor;

import java.util.logging.Logger;

@AllArgsConstructor
public class Swordsman implements Warrior {
    private static final Logger logger = Logger.getLogger(Swordsman.class.getName());
    private final int power;

    @Override
    public int getPower() {
        logger.info("java.heroes.Swordsman created with power: " + power);
        return power;
    }
}

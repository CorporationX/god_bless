package heroes;

import lombok.AllArgsConstructor;

import java.util.logging.Logger;

@AllArgsConstructor
public class Archer implements Warrior {
    private static final Logger logger = Logger.getLogger(Archer.class.getName());
    private final int power;

    @Override
    public int getPower() {
        logger.info("java.heroes.Archer created with power: " + power);
        return power;
    }
}

package threepigs;

import java.util.logging.Logger;

public class ThreeLittlePigs {
    private static final Logger logger = Logger.getLogger(ThreeLittlePigs.class.getName());

    public static void main(String[] args) {
        PigThread firstPig = new Pig1Thread("Nif-Nif", "straw");
        PigThread secondPig = new Pig2Thread("Nuf-Nuf", "branches");
        PigThread thirdPig = new Pig3Thread("Naf-Naf", "stone");

        firstPig.start();
        secondPig.start();
        thirdPig.start();

        try {
            firstPig.join();
            secondPig.join();
            thirdPig.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe("Construction interrupted unexpectedly!");
        }
        logger.info("Game is over!");
    }
}
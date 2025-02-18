package threepigs;

import java.util.logging.Logger;

public class Pig2Thread extends PigThread {
    private static final Logger logger = Logger.getLogger(Pig2Thread.class.getName());

    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            logger.info(String.format("%s starts constructing the house with %s", getPigName(), getMaterial()));
            Thread.sleep(3000);
            logger.info(String.format("%s has finished constructing the house with %s", getPigName(), getMaterial()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warning(String.format("%s: Construction interrupted!", getPigName()));
        }
    }
}

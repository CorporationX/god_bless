package threepigs;

import java.util.logging.Logger;

public class Pig1Thread extends PigThread {
    private static final Logger logger = Logger.getLogger(Pig1Thread.class.getName());

    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            logger.info(String.format("%s starts constructing the house with %s", getPigName(), getMaterial()));
            Thread.sleep(2000);
            logger.info(String.format("%s has finished constructing the house with %s", getPigName(), getMaterial()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warning(String.format("%s: Construction interrupted!", getPigName()));
        }
    }
}
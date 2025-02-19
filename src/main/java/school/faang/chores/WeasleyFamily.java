package school.faang.chores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeasleyFamily {
    private static final String[] CHORES = {"Wash dishes", "Clean the house", "Water plants"};
    private static final Logger LOGGER = Logger.getLogger(WeasleyFamily.class.getName());

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        LOGGER.setLevel(Level.INFO);
        for (String string : CHORES) {
            Chore chore = new Chore(string);
            executor.execute(chore);
            chore.run();
        }
        executor.shutdownNow();
        LOGGER.info("The work is done");
    }
}

package heroes;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
public class SquadThread extends Thread {
    private static final Logger logger = Logger.getLogger(SquadThread.class.getName());
    private final Squad<? extends Warrior> squad;
    private final List<Integer> results;

    @Override
    public void run() {
        logger.info("Thread for squad " + squad.getSquadType() + " started.");
        int power = squad.calculateSquadPower();
        results.add(power);
        logger.info("Thread for squad " + squad.getSquadType() + " finished with power: " + power);
    }
}

package heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.logging.Logger;

@Getter
@AllArgsConstructor
public class Squad<T extends Warrior> {
    private static final Logger logger = Logger.getLogger(Squad.class.getName());
    private final String squadType;
    private final List<T> warriors;

    public int calculateSquadPower() {
        logger.info("Calculating squad power for squad: " + squadType);
        int totalSquadPower = 0;
        for (var warrior : warriors) {
            totalSquadPower += warrior.getPower();
        }
        logger.info("java.heroes.Squad " + squadType + " total power: " + totalSquadPower);
        return totalSquadPower;
    }
}

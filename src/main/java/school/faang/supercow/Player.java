package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.logging.Logger;

@AllArgsConstructor
@Getter
public class Player {
    private static final Logger LOGGER = Logger.getLogger(Player.class.getName());
    private String name;


    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            LOGGER.severe(e.getMessage());
        }
    }

}

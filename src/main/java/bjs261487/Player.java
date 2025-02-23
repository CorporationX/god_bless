package bjs261487;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
@ToString
public class Player implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        boss.leaveBattle(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                    Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}

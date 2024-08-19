package faang.school.godbless.task.multithreading.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final static int DEFAULT_CURRENT_PLAYERS = 0;

    private final Logger logger = LoggerFactory.getLogger(Boss.class);
    private final int maxPlayer;
    private final Set<Player> currentPlayers;

    public void joinBattle(Player player) {
        try {
            synchronized (this) {
                while (currentPlayers.size() == maxPlayer) {
                    this.wait();
                }
                currentPlayers.add(player);
            }
            logger.info("Игрок {} начал сражается с боссом", player.getName());
            Thread.sleep(5000);
            logger.info("Игрок {} закончил сражение с боссом", player.getName());
            synchronized (this) {
                currentPlayers.remove(player);
                this.notifyAll();
            }
        } catch (InterruptedException exception) {
            logger.error("Interrupted exception: {}", exception.getMessage());
        }
    }
}

package school.faang.BJS2_61522;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private final Object lock = new Object();
    private final Set<Player> players;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.players = new HashSet<>();
    }

    public void joinBattle(@NonNull Player player) {
        synchronized (lock) {
            while (players.size() >= maxPlayers) {
                try {
                    log.info(SupercowMessages.NO_FREE_SPACE, player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error(SupercowMessages.SOMETHING_WENT_WRONG, e);
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            players.add(player);
            log.info(SupercowMessages.PLAYER_JOINED, player.getName());
        }
    }

    public void leaveBattle(@NonNull Player player) {
        synchronized (lock) {
            if (players.contains(player)) {
                players.remove(player);
                log.info(SupercowMessages.PLAYER_EXITED, player.getName());
                lock.notifyAll();
            } else {
                log.info(SupercowMessages.PLAYER_IS_NOT_PARTICIPATING, player.getName());
            }
        }
    }

}

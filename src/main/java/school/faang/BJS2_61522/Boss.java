package school.faang.BJS2_61522;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Set<Player> players = new HashSet<>();

    public void joinBattle(Player player) {
        synchronized (players) {
            if (currentPlayers >= maxPlayers) {
                try {
                    log.info("Для игрока {} нет свободного места в битве.", player.getName());
                    players.wait();
                } catch (InterruptedException e) {
                    log.error("Что-то пошло не так в потоке: \n{}", e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            players.add(player);
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (players) {
            if (players.contains(player)) {
                players.remove(player);
                currentPlayers--;
                log.info("Игрок вышел из битвы.");
                players.notify();
            }
            log.info("Игрок итак не участвует в битве.");
        }
    }

}

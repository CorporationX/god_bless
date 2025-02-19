package school.faang.supercow;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();
    private final Object lock = new Object();

    public void joinBattle(@NonNull Player player) {
        synchronized (lock) {
            try {
                if (currentPlayers.size() >= maxPlayers) {
                    log.info("Игрок {} ожидает, так как слоты заняты",
                            player.getName());
                    lock.wait();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Ожидание игрока {} прервано",
                        player.getName());
            }
            currentPlayers.add(player);
            log.info("Игрок {} присоединился к бою. Текущих игроков: {}",
                    player.getName(), currentPlayers.size());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers.remove(player);
            log.info("Игрок {} покинул бой. Текущих игроков: {}",
                    player.getName(), currentPlayers.size());
            lock.notify();
        }
    }
}

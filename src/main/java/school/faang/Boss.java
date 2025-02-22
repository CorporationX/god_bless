package school.faang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
public class Boss {
    private final int maxPlayers = 3;
    private final Set<Player> currentPlayers = new HashSet<>();

    private final Object lock = new Object();


    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers.size() < maxPlayers) {
                currentPlayers.add(player);
                log.info(player.getName() + " вступает в бой. " +
                        " Текущее количетсво игроков " + currentPlayers + "/" + maxPlayers);
            } else {
                try {
                    System.out.println("Слоты сейчас заполнены, подождите... ");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("Поток был прерван");
                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers.remove(player)) {
                log.info(player.getName() + " покинул бой." +
                        " Текущее количество игроков " + currentPlayers.size() + "/" + maxPlayers);
                lock.notify();
            } else {
                log.info(player.getName() + " не находится в бою.");
            }
        }

    }

}

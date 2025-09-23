package school.faang.m3_2_synchronized.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        while (currentPlayers.size() >= maxPlayers) {
            log.info("{} ждет места чтобы присоединиться к битве", player.getName());
            try {
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        currentPlayers.add(player);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers.remove(player);
        log.info("{} покинул битву", player.getName());
        notify();
    }
}

package src.faang.BJS2_73504.model;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Boss {
    private final int maxPlayers;

    private int currentPlayers;

    @SneakyThrows
    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            wait();
        }

        currentPlayers++;
        log.info("Player: {} {} joined the battle", player.name(), currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player: {} {} left the battle", player.name(), currentPlayers);
        notify();
    }
}



package school.faang.task_49656;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final String name;
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        if (currentPlayers.size() >= maxPlayers) {
            try {
                log.info("Player {} is waiting for a free slot to fight the boss {}", player.getName(), getName());
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        currentPlayers.add(player);
        log.info("Player {} joined the battle with the {} boss", player.getName(), getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers.remove(player);
        notify();
        log.info("Player {} leave from battle with the {} boss", player.getName(), getName());
    }
}
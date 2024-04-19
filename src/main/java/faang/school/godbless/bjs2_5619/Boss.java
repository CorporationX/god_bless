package faang.school.godbless.bjs2_5619;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Boss {

    private final String name;
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (currentPlayers) {
            if (currentPlayers.size() == maxPlayers) {
                try {
                    log.warn("All slots busy");
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
            log.info("{} start battle with {}", player.getName(), name);
            currentPlayers.add(player);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (currentPlayers) {
            currentPlayers.remove(player);
            log.info("{} leave battle", player.getName());
            currentPlayers.notify();
        }
    }
}

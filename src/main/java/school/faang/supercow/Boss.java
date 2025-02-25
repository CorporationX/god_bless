package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = new ArrayList<>();
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (currentPlayers) {
            while (currentPlayers.size() >= maxPlayers) {
                log.info("{} ждет своей очереди для входа в бой", player.name());
                currentPlayers.wait();
            }
            currentPlayers.add(player);
            log.info("Добавлен игрок - {}", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (currentPlayers) {
            currentPlayers.remove(player);
            log.info("Удален игрок - {}", player.name());
            currentPlayers.notify();
        }
    }

}

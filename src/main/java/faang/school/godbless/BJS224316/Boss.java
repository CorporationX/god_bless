package faang.school.godbless.BJS224316;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class Boss {
    private final int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            System.out.println(lock);
            while (currentPlayers.size() == maxPlayers) {
                log.info("{} is waiting for a spot in the battle.", player.getName());
                lock.wait();
            }
            currentPlayers.add(player);
            log.info("{} joined the battle. Current players: {}", player.getName(), currentPlayers.size());
        }
    }
}

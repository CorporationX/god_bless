package faang.school.godbless.BJS224316;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@ToString
public class Boss {
    private final int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers.size() == maxPlayers) {
            log.info("{} is waiting for a spot in the battle.", player.getName());
            this.wait();
        }
        currentPlayers.add(player);
        log.info("{} joined the battle. Current players: {}", player.getName(), currentPlayers.size());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers.remove(player);
        log.info("Player {} left the fight", player.getName());
        notifyAll();
    }
}

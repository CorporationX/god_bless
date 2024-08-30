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

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (player) {
            System.out.println(player);
            while (currentPlayers.size() == maxPlayers) {
                log.info("{} is waiting for a spot in the battle.", player.getName());
                player.wait();
            }
            currentPlayers.add(player);
            log.info("{} joined the battle. Current players: {}", player.getName(), currentPlayers.size());
        }
    }

    public void removePlayer(Player player){
        currentPlayers.remove(player);
    }
}

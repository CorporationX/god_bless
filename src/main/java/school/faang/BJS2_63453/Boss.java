package school.faang.BJS2_63453;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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
            if (currentPlayers.size() >= maxPlayers) {
                log.info(String.format(
                        "⏳ %s ждёт свободного слота для боя с боссом...%n",
                        player.getName()));
                lock.wait();
            }
            currentPlayers.add(player);
            log.info(String.format("⚔️ %s присоединился к битве! (%d/%d)%n",
                    player.getName(), currentPlayers.size(), maxPlayers));
        }
    }

    public void leaveBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            Thread.sleep(1000);
            currentPlayers.remove(player);
            log.info(String.format("🏃 %s покинул битву. (%d/%d)%n",
                    player.getName(), currentPlayers.size(), maxPlayers));
            lock.notify();
        }
    }
}

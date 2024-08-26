package faang.school.godbless.BJS224326;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    List<Player> list = new ArrayList<>();

    public void joinBattle(Player player) {
        addPlayer(player);
        fight(player);
        removePlayer(player);
    }

    public void addPlayer(Player player) {
        synchronized (this) {
            if (list.size() == maxPlayers) {
                log.info(player.getName() + " перешел в ожидание");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info(player.getName() + " вышел из режима ожидания ");
            }
            list.add(player);
        }
    }

    public static void fight(Player player) {
        try {
            log.info(player.getName() + " сражается с босом");
            Thread.sleep(2000);
            log.info(player.getName() + " закончил сражается с босом");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void removePlayer(Player player) {
        synchronized (this) {
            log.info(" " + player.getName() + "вышел освободилось место");
            list.remove(player);
            this.notifyAll();
        }
    }
}






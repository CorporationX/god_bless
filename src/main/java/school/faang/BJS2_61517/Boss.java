package school.faang.BJS2_61517;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Slf4j
public class Boss {

    private final int maxPlayers;
    private int currentPlayers;
    private final List<Player> battle = new ArrayList<>();

    public void joinBattle(Player player) {
        synchronized (battle) {
            while (getCurrentPlayers() == getMaxPlayers()) {
                log.info("Игрок {} не может войти в сражение, так как не осталось мест!", player.getName());
                try {
                    battle.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("Осталось {} место", getMaxPlayers() - getBattle().size());
            addPlayerBattle(player);
        }
    }

    public void leaveBattle(Player player) {
        if (!battle.contains(player)) {
            log.info("Игрок {} не может покинуть бой, так как он в нем не участвует", player.getName());
            return;
        }
        synchronized (battle) {
            currentPlayers--;
            log.info("Игрок {} покинул бой", player.getName());
            battle.remove(player);
            battle.notify();
        }
    }

    private void addPlayerBattle(Player player) {
        currentPlayers++;
        battle.add(player);
        log.info("Игрок с именем {} добавлен в сражение", player.getName());
    }
}

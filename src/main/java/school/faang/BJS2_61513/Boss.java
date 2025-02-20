package school.faang.BJS2_61513;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers == maxPlayers) {
            this.wait();
            log.info("{} ожидает сражения ", player.name());
        }
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers > 0) {
            currentPlayers--;
            log.info("{} покинул сражение.", player.name());
            this.notifyAll();
        } else {
            System.out.println("Ошибка: Нет игроков для выхода из сражения.");
        }
    }
}
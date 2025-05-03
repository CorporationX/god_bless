package school.faang.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class Boss {
    private final int maxPlayer;
    private int currentPlayer;

    public synchronized void joinBattle(Player player) {
        while (currentPlayer >= maxPlayer) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("Вступает в битву " + player.getName());
        currentPlayer++;
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayer--;
        log.info(player.getName() + " Завершил битву");
        notify();
    }
}

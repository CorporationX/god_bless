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

    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (!(currentPlayer >= maxPlayer)) {
                currentPlayer++;
                System.out.println(player.getName() + " Вступает в бой");
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Ошибка при вызове потока", e);
                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayer--;
            System.out.println(player.getName() + " Завершил битву");
            lock.notify();
        }
    }
}

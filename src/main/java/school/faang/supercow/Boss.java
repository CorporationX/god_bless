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
        if (currentPlayer < maxPlayer) {
            currentPlayer++;
            System.out.println(player.getName() + " Вступает в бой");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayer--;
        System.out.println(player.getName() + " Завершил битву");
        notify();
    }
}
